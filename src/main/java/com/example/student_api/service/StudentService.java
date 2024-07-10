package com.example.student_api.service;

import org.springframework.stereotype.Service;

import com.example.student_api.dtomodel.StudentDTO;
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

    public StudentDTO findStudentById(Long id)
    {
        StudentEntity studentEntity = studentRepository.findById(id).orElse(null);
        return new StudentDTO(
            studentEntity.getId(), 
            studentEntity.getName(), 
            studentEntity.getGender()
        );
    }

    public StudentEntity saveStudent(StudentDTO studentDTO)
    {
        StudentEntity studentEntity = new StudentEntity(
            studentDTO.getName(), 
            studentDTO.getGender()
        );
        return studentRepository.save(studentEntity);
    }

    public void deleteStudentById(Long id)
    {
        studentRepository.deleteById(id);
    }
}
