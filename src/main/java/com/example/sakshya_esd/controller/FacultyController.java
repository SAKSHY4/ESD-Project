package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Faculty;
import com.example.sakshya_esd.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculty")
public class FacultyController {
    @Autowired
    private FacultyService facultyService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody Faculty faculty) {
        facultyService.create(faculty);
        return ResponseEntity.ok("SUCCESS");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Faculty> getFacultyById(@PathVariable("id") Integer id) {
        return facultyService.getFacultyById(id);
    }
}
