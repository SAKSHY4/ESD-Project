package com.example.sakshya_esd.mapper;

import com.example.sakshya_esd.dto.StudentCourseDTO;
import com.example.sakshya_esd.entity.*;
import com.example.sakshya_esd.repository.CourseRepository;
import com.example.sakshya_esd.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseMapper {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Studentcourse toEntity(StudentCourseDTO studentCourseDTO) {
        Student student = studentRepository.findById(Math.toIntExact(studentCourseDTO.getStudentId())).orElseThrow(() -> new RuntimeException("Default Faculty not found"));
        Course course = courseRepository.findById(Math.toIntExact(studentCourseDTO.getCourseId())).orElseThrow(() -> new RuntimeException("Default Course not found"));

        return Studentcourse.builder()
                .student(student)
                .course(course)
                .build();
    }
}
