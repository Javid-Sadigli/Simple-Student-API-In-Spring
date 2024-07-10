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

        System.out.println(studentEntity);

        return new StudentDTO(
            studentEntity.getId(), 
            studentEntity.getName(), 
            studentEntity.getGender()
        );
    }

    public StudentDTO saveStudent(StudentDTO studentDTO)
    {
        StudentEntity studentEntity = new StudentEntity(
            studentDTO.getName(), 
            studentDTO.getGender()
        );
        StudentEntity saved = studentRepository.save(studentEntity);

        return new StudentDTO(
            saved.getId(), 
            saved.getName(), 
            saved.getGender()
        );
    }
    
    public StudentDTO saveStudent(StudentDTO studentDTO, Long studentId)
    {
        StudentEntity studentEntity = new StudentEntity(
            studentDTO.getName(), 
            studentDTO.getGender()
        );
        studentEntity.setId(studentId);

        System.out.println(studentEntity);

        StudentEntity saved = studentRepository.save(studentEntity);
        return new StudentDTO(
            saved.getId(), 
            saved.getName(), 
            saved.getGender()
        );
    }

    public void deleteStudentById(Long id)
    {
        studentRepository.deleteById(id);
    }
}
