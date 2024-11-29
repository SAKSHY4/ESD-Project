package com.example.sakshya_esd.repository;

import com.example.sakshya_esd.entity.Course;
import com.example.sakshya_esd.entity.Facultycourse;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacultyCourseRepository extends JpaRepository<Facultycourse, Integer> {
    List<Facultycourse> findByCourseIn(List<Course> courses);
}
