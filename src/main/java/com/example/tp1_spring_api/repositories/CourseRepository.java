package com.example.tp1_spring_api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp1_spring_api.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
