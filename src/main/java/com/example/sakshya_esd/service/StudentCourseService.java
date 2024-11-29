package com.example.sakshya_esd.service;

import com.example.sakshya_esd.dto.StudentCourseDTO;
import com.example.sakshya_esd.mapper.StudentCourseMapper;
import com.example.sakshya_esd.repository.StudentCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {
    @Autowired
    private StudentCourseRepository studentCourseRepository;

    @Autowired
    private StudentCourseMapper studentCourseMapper;

    public void create(StudentCourseDTO studentCourseDTO) {
        studentCourseRepository.save(studentCourseMapper.toEntity(studentCourseDTO));
    }
}
