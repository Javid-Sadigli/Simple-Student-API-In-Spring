package com.example.student_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;

@Mapper(componentModel = "spring")
public interface StudentMapper
{
    public StudentDTO toStudentDTO(StudentEntity studentEntity); 
    public StudentEntity toStudentEntity(StudentDTO studentDTO);

    @Mapping(target = "id", source = "studentId")
    public StudentEntity toStudentEntity(StudentDTO studentDTO, Long studentId);
}