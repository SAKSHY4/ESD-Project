package com.example.sakshya_esd.repository;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Courseschedule;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseScheduleRepository extends JpaRepository<Courseschedule, Integer> {
    List<Courseschedule> findByCourseIn(List<Course> courses);
}
