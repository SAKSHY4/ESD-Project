package com.example.sakshya_esd.mapper;

import com.example.sakshya_esd.dto.SpecializationCourseDTO;
import com.example.sakshya_esd.entity.*;
import com.example.sakshya_esd.repository.CourseRepository;
import com.example.sakshya_esd.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationCourseMapper {
    @Autowired
    private SpecializationRepository specializationRepository;

    @Autowired
    private CourseRepository courseRepository;

    public Specializationcourse toEntity(SpecializationCourseDTO specializationCourseDTO) {
        Specialization specialization = specializationRepository.findById(Math.toIntExact(specializationCourseDTO.getSpecializationId())).orElseThrow(() -> new RuntimeException("Default Faculty not found"));
        Course course = courseRepository.findById(Math.toIntExact(specializationCourseDTO.getCourseId())).orElseThrow(() -> new RuntimeException("Default Course not found"));

        return Specializationcourse.builder()
                .specialization(specialization)
                .course(course)
                .build();
    }
}
