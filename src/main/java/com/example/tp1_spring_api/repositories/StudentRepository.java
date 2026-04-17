package com.example.tp1_spring_api.repositories;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.tp1_spring_api.entities.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);
    Page<Student> findAll(Pageable pageable);
    

    
}

