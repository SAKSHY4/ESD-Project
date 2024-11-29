package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.dto.FacultyCourseDTO;
import com.example.sakshya_esd.dto.FacultyCourseResultDTO;
import com.example.sakshya_esd.service.FacultyCourseService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/faculty_course")
public class FacultyCourseController {
    @Autowired
    private FacultyCourseService facultyCourseService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody FacultyCourseDTO facultyCourseDTO) {
        facultyCourseService.create(facultyCourseDTO);
        return ResponseEntity.ok("SUCCESS");
    }

    @GetMapping
    public ResponseEntity<List<FacultyCourseResultDTO>> getFacultyCourses(HttpServletRequest request) {
        List<FacultyCourseResultDTO> facultyCourseResultDTOList = facultyCourseService.getFacultyCourses(request);
        return ResponseEntity.ok(facultyCourseResultDTOList);
    }
}
