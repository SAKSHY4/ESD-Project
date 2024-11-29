package com.example.sakshya_esd.controller;

import com.example.sakshya_esd.dto.CourseScheduleDTO;
import com.example.sakshya_esd.service.CourseScheduleService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("course_schedule")
public class CourseScheduleController {
    @Autowired
    private CourseScheduleService courseScheduleService;

    @PostMapping
    public ResponseEntity<String> create(@RequestBody CourseScheduleDTO courseScheduleDTO) {
        courseScheduleService.create(courseScheduleDTO);
        return ResponseEntity.ok("SUCCESS");
    }

    @GetMapping
    public ResponseEntity<List<CourseScheduleDTO>> getCourseSchedule(HttpServletRequest request) {
        List<CourseScheduleDTO> courseScheduleDTOList = courseScheduleService.getCourseSchedule(request);
        return ResponseEntity.ok(courseScheduleDTOList);
    }


}
