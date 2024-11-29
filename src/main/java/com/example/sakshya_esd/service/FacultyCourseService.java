package com.example.sakshya_esd.service;

import com.example.sakshya_esd.dto.FacultyCourseDTO;
import com.example.sakshya_esd.dto.FacultyCourseResultDTO;
import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Facultycourse;
import com.example.sakshya_esd.entity.Student;
import com.example.sakshya_esd.entity.Studentcourse;
import com.example.sakshya_esd.mapper.FacultyCourseMapper;
import com.example.sakshya_esd.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FacultyCourseService {
    @Autowired
    private FacultyCourseRepository facultyCourseRepository;

    @Autowired
    private FacultyCourseMapper facultyCourseMapper;
    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;
    @Autowired
    private CourseScheduleRepository courseScheduleRepository;

    public void create(FacultyCourseDTO facultyCourseDTO) {
        facultyCourseRepository.save(facultyCourseMapper.toEntity(facultyCourseDTO));
    }

    public List<FacultyCourseResultDTO> getFacultyCourses(HttpServletRequest request) {
        String rollno = studentService.getRollNumber(request);
        Student student = studentRepository.findByRollNumber(rollno);
        Long studentId = student.getId();
        List<Studentcourse> courses = studentCourseRepository.findByStudentId(studentId);
        List<Course> courseList = courses.stream().map(Studentcourse::getCourse).toList();
        List<Facultycourse> facultyCourses = facultyCourseRepository.findByCourseIn(courseList);
        return facultyCourses.stream()
                .map(facultyCourse -> FacultyCourseResultDTO.builder()
                        .facultyId(facultyCourse.getFaculty().getId()) // Faculty ID
                        .facultyName(facultyCourse.getFaculty().getFirstName() + " " + facultyCourse.getFaculty().getLastName()) // Faculty name
                        .courseName(facultyCourse.getCourse().getName()) // Course name
                        .courseCode(facultyCourse.getCourse().getCourseCode()) // Course code
                        .build())
                .collect(Collectors.toList());
    }
}
