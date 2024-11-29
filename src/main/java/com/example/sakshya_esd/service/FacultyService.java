package com.example.sakshya_esd.service;

import com.example.sakshya_esd.entity.Faculty;
import com.example.sakshya_esd.repository.FacultyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FacultyService {
    @Autowired
    private FacultyRepository facultyRepository;

    public void create(Faculty faculty) {
        facultyRepository.save(faculty);
    }

    public ResponseEntity<Faculty> getFacultyById(Integer id) {
        Optional<Faculty> faculty = facultyRepository.findById(id);
        return faculty.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
