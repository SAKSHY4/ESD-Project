package com.example.sakshya_esd.service;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public void create(Course course) {
        courseRepository.save(course);
    }
}
