package com.example.student_api.mapper;

import org.springframework.stereotype.Service;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;

@Service
public class StudentMapper 
{
    public StudentDTO toStudentDTO(StudentEntity studentEntity)
    {
        return new StudentDTO(
            studentEntity.getId(),
            studentEntity.getName(),
            studentEntity.getGender()
        );
    }

    public StudentEntity toStudentEntity(StudentDTO studentDTO)
    {
        return new StudentEntity(
            studentDTO.getName(),
            studentDTO.getGender()
        );
    }
    public StudentEntity toStudentEntity(StudentDTO studentDTO, Long studentId)
    {
        return new StudentEntity(
            studentId,
            studentDTO.getName(), 
            studentDTO.getGender()
        );
    }
}
