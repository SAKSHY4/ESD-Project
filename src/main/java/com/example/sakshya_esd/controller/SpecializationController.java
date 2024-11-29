package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.entity.Specialization;
import com.example.sakshya_esd.service.SpecializationService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/specialization")
public class SpecializationController {
    @Autowired
    private SpecializationService specializationService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Specialization specialization) {
        specializationService.create(specialization);
        return ResponseEntity.ok("SUCCESS");
    }
}
