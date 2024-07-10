package com.example.student_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dtomodel.StudentDTO;
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
    public StudentDTO getStudentById(@PathVariable Long id) 
    {
        return this.studentService.findStudentById(id);
    }

    @PostMapping
    public StudentEntity saveStudent(@RequestBody StudentDTO student) 
    {    
        return this.studentService.saveStudent(student);
    }

    @PutMapping("/{id}")
    public StudentEntity updateStudent(@PathVariable Long id, @RequestBody StudentDTO updated)
    {
        updated.setId(id);
        return this.studentService.saveStudent(updated);
    }

    @DeleteMapping("/{id}")
    public void deleteStudentById(@PathVariable Long id)
    {
        this.studentService.deleteStudentById(id);
    }
}
