package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.dto.StudentCourseDTO;
import com.example.sakshya_esd.service.StudentCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student_course")
public class StudentCourseController {
    @Autowired
    private StudentCourseService studentCourseService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody StudentCourseDTO studentCourseDTO) {
        System.out.println("HELLO");
        studentCourseService.create(studentCourseDTO);
        return ResponseEntity.ok("SUCCESS");
    }
}
