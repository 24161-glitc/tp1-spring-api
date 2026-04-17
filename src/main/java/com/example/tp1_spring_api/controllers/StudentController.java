package com.example.tp1_spring_api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.tp1_spring_api.entities.Student;
import com.example.tp1_spring_api.repositories.StudentRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    
    @GetMapping
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    
    @GetMapping("/paged")
    public Page<Student> getAllPaged(Pageable pageable) {
        return studentRepository.findAll(pageable);
    }

   
    @GetMapping("/search")
    public List<Student> searchByName(@RequestParam String name) {
        return studentRepository.findByName(name);
    }

    
    @GetMapping("/{id}")
    public Student getById(@PathVariable Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Student not found"));
    }

    
    @PostMapping
    public Student create(@RequestBody @Valid Student student) {
        return studentRepository.save(student);
    }

    
    @PutMapping("/{id}")
    public Student update(@PathVariable Long id, @RequestBody Student studentDetails) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Étudiant non trouvé"));
        
        student.setName(studentDetails.getName());
        student.setEmail(studentDetails.getEmail());
        
        return studentRepository.save(student);
    }

    
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        studentRepository.deleteById(id);
    }
}