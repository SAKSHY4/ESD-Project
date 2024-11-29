package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.dto.SpecializationCourseDTO;
import com.example.sakshya_esd.service.SpecializationCourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialization_course")
public class SpecializationCourseController {
    @Autowired
    private SpecializationCourseService specializationCourseService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody SpecializationCourseDTO specializationCourseDTO) {
        specializationCourseService.create(specializationCourseDTO);
        return ResponseEntity.ok("SUCCESS");
    }
}