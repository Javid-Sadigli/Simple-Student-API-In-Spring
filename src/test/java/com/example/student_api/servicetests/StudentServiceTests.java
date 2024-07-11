package com.example.student_api.servicetests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.example.student_api.dtomodel.StudentDTO;
import com.example.student_api.entity.StudentEntity;
import com.example.student_api.repository.StudentRepository;
import com.example.student_api.service.StudentService;

public class StudentServiceTests 
{
    @Mock
    private StudentRepository studentRepository;

    @InjectMocks 
    private StudentService studentService;

    @BeforeEach
    public void setUp()
    {
        MockitoAnnotations.openMocks(this);
    }

    /* Testing methods */

    @Test 
    @DisplayName("Testing of findStudentById method")
    public void testFindStudentById()
    {
        String studentName = "Javid Sadigli", studentGender = "Male";
        Long studentId = 1L; 

        StudentEntity mockStudentEntity = new StudentEntity(studentName, studentGender);
        mockStudentEntity.setId(studentId);

        Mockito.when(studentRepository.findById(studentId)).thenReturn(java.util.Optional.of(mockStudentEntity));

        StudentDTO result = this.studentService.findStudentById(studentId); 

        assertEquals(studentId, result.getId());
        assertEquals(studentName, result.getName());
        assertEquals(studentGender, result.getGender());
    }
}
