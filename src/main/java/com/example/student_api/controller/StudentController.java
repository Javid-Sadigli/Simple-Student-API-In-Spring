package com.example.student_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.student_api.entity.StudentEntity;
import com.example.student_api.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api/student")
public class StudentController 
{
    private final StudentService studentService;

    public StudentController(StudentService studentService)
    {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentEntity getStudentById(@PathVariable Long id) 
    {
        return this.studentService.findStudentById(id);
    }

    @PostMapping
    public StudentEntity saveStudent(@RequestBody StudentEntity entity) 
    {    
        return this.studentService.saveStudent(entity);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentEntity updatedEntity)
    {
        updatedEntity.setId(id);
        return this.studentService.saveStudent(updatedEntity);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
        this.studentService.deleteStudentById(id);
    }
}
