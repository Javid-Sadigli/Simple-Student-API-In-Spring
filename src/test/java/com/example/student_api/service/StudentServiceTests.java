package com.example.student_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;
import com.example.student_api.mapper.StudentMapper;
import com.example.student_api.repository.StudentRepository;

public class StudentServiceTests 
{
    @Mock
    private StudentRepository studentRepository;

    @Mock 
    private StudentMapper studentMapper; 

    @InjectMocks 
    private StudentService studentService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Testing if StudentService is saving Student.")
    public void shouldSaveStudent()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        StudentDTO studentDTO = new StudentDTO(studentName, studentGender);
        StudentEntity studentEntity = new StudentEntity(studentName, studentGender);

        when(this.studentMapper.toStudentEntity(studentDTO)).thenReturn(studentEntity);
        when(this.studentRepository.save(studentEntity)).thenReturn(studentEntity); 
        when(this.studentMapper.toStudentDTO(studentEntity)).thenReturn(studentDTO);

        StudentDTO savedStudent = this.studentService.saveStudent(studentDTO);
        
        assertEquals(studentName, savedStudent.getName());
        assertEquals(studentGender, savedStudent.getGender());
    }

    @Test 
    @DisplayName("Testing if StudentService is updating Student")
    public void shouldUpdateStudent()
    {   
        String newStudentName = "Javid Sadigli", newStudentGender = "male"; 
        Long studentId = 1L;

        StudentDTO studentDTO = new StudentDTO(newStudentName, newStudentGender);
        StudentDTO updatedStudentDTO = new StudentDTO(studentId, newStudentName, newStudentGender); 
        StudentEntity studentEntity = new StudentEntity(studentId, newStudentName, newStudentGender);

        when(this.studentMapper.toStudentEntity(studentDTO, studentId)).thenReturn(studentEntity);
        when(this.studentRepository.save(studentEntity)).thenReturn(studentEntity);
        when(this.studentMapper.toStudentDTO(studentEntity)).thenReturn(updatedStudentDTO); 

        StudentDTO checkUpdatedStudentDTO = this.studentService.saveStudent(studentDTO, studentId);

        assertNotNull(checkUpdatedStudentDTO);
        assertEquals(newStudentName, checkUpdatedStudentDTO.getName());
        assertEquals(newStudentGender, checkUpdatedStudentDTO.getGender());
        assertEquals(studentId, checkUpdatedStudentDTO.getId());
    }

    @Test
    @DisplayName("Testing if StudentService is finding student by id.")
    public void shouldFindStudentById()
    {
        String studentName = "Javid Sadigli", studentGender = "male";
        Long studentId = 1L;

        StudentEntity foundStudentEntity = new StudentEntity(studentId, studentName, studentGender);
        StudentDTO foundStudentDTO = new StudentDTO(studentId, studentName, studentGender);

        when(this.studentRepository.findById(studentId)).thenReturn(Optional.of(foundStudentEntity));
        when(this.studentMapper.toStudentDTO(foundStudentEntity)).thenReturn(foundStudentDTO); 

        StudentDTO checkFoundStudentDTO = this.studentService.findStudentById(studentId);

        assertNotNull(checkFoundStudentDTO);
        assertEquals(studentId, checkFoundStudentDTO.getId());
        assertEquals(studentName, checkFoundStudentDTO.getName());
        assertEquals(studentGender, checkFoundStudentDTO.getGender());
    }

    @Test
    @DisplayName("Testing if StudentService is finding student with null id.")
    public void shouldReturnNullWhenStudentIdIsNull()
    {
        Long studentId = null;
        StudentDTO checkFoundStudentDTO = this.studentService.findStudentById(studentId);
        assertNull(checkFoundStudentDTO);
    }

    @Test
    @DisplayName("Testing if StudentService is updating student with null id.")
    public void shouldReturnNullWhenStudentIdForUpdateIsNull()
    {
        Long studentId = null;
        String newStudentName = "Javid Sadigli", newStudentGender = "male";
        StudentDTO studentDTO = new StudentDTO(newStudentName, newStudentGender);
        StudentDTO checkUpdatedStudentDTO = this.studentService.saveStudent(studentDTO, studentId);
        assertNull(checkUpdatedStudentDTO);
    }
}
