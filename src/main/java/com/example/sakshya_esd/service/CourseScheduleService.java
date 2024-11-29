package com.example.sakshya_esd.service;

import com.example.sakshya_esd.dto.CourseScheduleDTO;
import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Courseschedule;
import com.example.sakshya_esd.entity.Student;
import com.example.sakshya_esd.entity.Studentcourse;
import com.example.sakshya_esd.mapper.CourseScheduleMapper;
import com.example.sakshya_esd.repository.CourseScheduleRepository;
import com.example.sakshya_esd.repository.StudentCourseRepository;
import com.example.sakshya_esd.repository.StudentRepository;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CourseScheduleService {
    @Autowired
    private CourseScheduleRepository courseScheduleRepository;

    @Autowired
    private CourseScheduleMapper courseScheduleMapper;

    @Autowired
    private StudentService studentService;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    public void create(CourseScheduleDTO courseScheduleDTO) {
        courseScheduleRepository.save(courseScheduleMapper.toEntity(courseScheduleDTO));
    }

    public List<CourseScheduleDTO> getCourseSchedule(HttpServletRequest request) {
        String rollno = studentService.getRollNumber(request);
        Student student = studentRepository.findByRollNumber(rollno);
        Long studentId = student.getId();
        List<Studentcourse> courses = studentCourseRepository.findByStudentId(studentId);
        List<Course> courseList = courses.stream().map(Studentcourse::getCourse).toList();
        List<Courseschedule> courseSchedules = courseScheduleRepository.findByCourseIn(courseList);
        return courseSchedules.stream()
                .map(courseSchedule -> CourseScheduleDTO.builder()
                        .courseId(courseSchedule.getCourse().getId())
                        .courseName(courseSchedule.getCourse().getName())
                        .courseCode(courseSchedule.getCourse().getCourseCode())
                        .time(courseSchedule.getTime())
                        .day(courseSchedule.getDay())
                        .room(courseSchedule.getRoom())
                        .building(courseSchedule.getBuilding())
                        .build())
                .collect(Collectors.toList());
    }
}
