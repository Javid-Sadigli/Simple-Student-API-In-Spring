package com.example.student_api.service;

import org.springframework.stereotype.Service;

import com.example.student_api.entity.StudentEntity;
import com.example.student_api.repository.StudentRepository;

@Service
public class StudentService 
{
    private final StudentRepository studentRepository; 

    public StudentService(StudentRepository studentRepository) 
    {
        this.studentRepository = studentRepository;
    }

    public StudentEntity findStudentById(Long id)
    {
        return studentRepository.findById(id).orElse(null);
    }

    public StudentEntity saveStudent(StudentEntity studentEntity)
    {
        return studentRepository.save(studentEntity);
    }

    public void deleteStudentById(Long id)
    {
        studentRepository.deleteById(id);
    }


}
