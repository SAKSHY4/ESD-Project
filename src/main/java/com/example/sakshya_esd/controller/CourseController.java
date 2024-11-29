package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Course course) {
        courseService.create(course);
        return ResponseEntity.ok("SUCCESS");
    }
}
