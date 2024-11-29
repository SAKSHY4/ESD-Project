package com.example.sakshya_esd.service;

import com.example.sakshya_esd.entity.Specialization;
import com.example.sakshya_esd.repository.SpecializationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SpecializationService {
    @Autowired
    private SpecializationRepository specializationRepository;

    public void create(Specialization specialization) {
        specializationRepository.save(specialization);
    }
}
