package com.example.sakshya_esd.repository;

import com.example.sakshya_esd.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    Student findByRollNumber(String rollnumber);
}