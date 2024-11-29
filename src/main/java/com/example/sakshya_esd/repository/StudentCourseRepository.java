package com.example.sakshya_esd.repository;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Courseschedule;
import com.example.sakshya_esd.entity.Studentcourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentCourseRepository extends JpaRepository<Studentcourse, Integer> {
    List<Studentcourse> findByStudentId(Long studentId);
}
