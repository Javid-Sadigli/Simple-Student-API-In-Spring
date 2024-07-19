package com.example.student_api.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
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

        assertNotNull(studentEntity);
        assertEquals(studentName, studentEntity.getName());
        assertEquals(studentGender, studentEntity.getGender());
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

        assertNotNull(studentEntity);
        assertEquals(studentId, studentEntity.getId());
        assertEquals(studentName, studentEntity.getName());
        assertEquals(studentGender, studentEntity.getGender());
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

        assertNotNull(studentDTO);
        assertEquals(studentName, studentDTO.getName());
        assertEquals(studentGender, studentDTO.getGender());
        assertEquals(studentId, studentDTO.getId());
    }

    @Test 
    @DisplayName("Testing if StudentMapper.toStudentEntity() method will return null if the id is null.")
    public void shouldReturnNullWhenIdIsNull()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        Long studentId = null;
        StudentDTO studentDTO = new StudentDTO(
            studentName, 
            studentGender
        );  

        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO, studentId); 

        assertNull(studentEntity);
    }

    @Test 
    @DisplayName("Testing if StudentMapper.toStudentEntity() method will return null if the studentDTO is null.")
    public void shouldReturnNullWhenStudentDtoIsNull()
    {
        StudentDTO studentDTO = null;
        Long studentId = 1L;

        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO, studentId);

        assertNull(studentEntity);
    }

    @Test
    @DisplayName("Testing if StudentMapper.toStudentEntity() method will return null if the studentDTO is null (without giving studentId)")
    public void shouldReturnNullWhenStudentDtoIsNull_WithoutGivingId()
    {
        StudentDTO studentDTO = null;
        StudentEntity studentEntity = this.studentMapper.toStudentEntity(studentDTO);
        assertNull(studentEntity);
    }

    @Test 
    @DisplayName("Testing if StudentMapper.toStudentDTO() method will return null if the studentEntity is null.")
    public void shouldReturnNullWhenStudentEntityIsNull()
    {
        StudentEntity studentEntity = null;
        StudentDTO studentDTO = this.studentMapper.toStudentDTO(studentEntity);
        
        assertNull(studentDTO);
    }
}