package com.example.sakshya_esd.mapper;

import com.example.sakshya_esd.dto.FacultyCourseDTO;
import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Faculty;
import com.example.sakshya_esd.entity.Facultycourse;
import com.example.sakshya_esd.repository.CourseRepository;
import com.example.sakshya_esd.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FacultyCourseMapper {
    @Autowired
    private FacultyRepository facultyRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Facultycourse toEntity(FacultyCourseDTO facultyCourseDTO){
        Faculty faculty = facultyRepository.findById(Math.toIntExact(facultyCourseDTO.getFacultyId())).orElseThrow(() -> new RuntimeException("Default Faculty not found"));
        Course course = courseRepository.findById(Math.toIntExact(facultyCourseDTO.getCourseId())).orElseThrow(() -> new RuntimeException("Default Course not found"));

        return Facultycourse.builder()
                .faculty(faculty)
                .course(course)
                .build();
    }
}
