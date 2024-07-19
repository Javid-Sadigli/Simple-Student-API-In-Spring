package com.example.student_api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;

public class StudentMapperTests 
{
    private StudentMapper studentMapper; 

    @BeforeEach
    public void setUp()
    {
        studentMapper = new StudentMapper();  
    }

    @Test
    @DisplayName("Testing if StudentMapper can convert StudentDTO to StudentEntity without id.")
    public void shouldMapStudentDtoToStudentEntityWithoutId()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        StudentDTO studentDTO = new StudentDTO(
            studentName,
            studentGender
        ); 

        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO);

        assertEquals(studentEntity.getName(), studentName);
        assertEquals(studentEntity.getGender(), studentGender);
        assertNull(studentEntity.getId());
    }

    @Test
    @DisplayName("Testing if StudentMapper can convert StudentDTO to StudentEntity with id.")
    public void shouldMapStudentDtoToStudentEntityWithId()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        Long studentId = 1L;
        StudentDTO studentDTO = new StudentDTO(
            studentName,
            studentGender
        ); 

        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO, studentId); 

        assertEquals(studentEntity.getId(), studentId);
        assertEquals(studentEntity.getName(), studentName);
        assertEquals(studentEntity.getGender(), studentGender);
    }

    @Test
    @DisplayName("Testing if StudentMapper can convert StudentEntity to StudentDTO.")
    public void shouldMapStudentEntityToStudentDto()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        Long studentId = 1L;
        StudentEntity studentEntity = new StudentEntity(
            studentId,
            studentName,
            studentGender
        );
        
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentEntity);

        assertEquals(studentDTO.getName(), studentName);
        assertEquals(studentDTO.getGender(), studentGender);
        assertEquals(studentDTO.getId(), studentId);
    }

}
