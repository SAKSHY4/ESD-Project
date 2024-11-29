package com.example.sakshya_esd.mapper;

import com.example.sakshya_esd.dto.CourseScheduleDTO;
import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Courseschedule;
import com.example.sakshya_esd.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseScheduleMapper {
    @Autowired
    private CourseRepository courseRepository;

    public Courseschedule toEntity(CourseScheduleDTO courseScheduleDTO) {
        Course course = courseRepository.findById(Math.toIntExact(courseScheduleDTO.getCourseId())).orElseThrow(() -> new RuntimeException("Default Course not found"));

        return Courseschedule.builder()
                .course(course)
                .day(courseScheduleDTO.getDay())
                .time(courseScheduleDTO.getTime())
                .room(courseScheduleDTO.getRoom())
                .building(courseScheduleDTO.getBuilding())
                .build();
    }
}
