package com.example.sakshya_esd.service;

import com.example.sakshya_esd.dto.SpecializationCourseDTO;
import com.example.sakshya_esd.mapper.SpecializationCourseMapper;
import com.example.sakshya_esd.repository.SpecializationCourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationCourseService {
    @Autowired
    private SpecializationCourseRepository specializationCourseRepository;

    @Autowired
    private SpecializationCourseMapper specializationCourseMapper;

    public void create(SpecializationCourseDTO specializationCourseDTO) {
        specializationCourseRepository.save(specializationCourseMapper.toEntity(specializationCourseDTO));
    }
}
