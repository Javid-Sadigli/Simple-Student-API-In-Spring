package com.example.student_api.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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

    /* Testing methods */

    // @Test 
    // @DisplayName("Testing of findStudentById method")
    // public void testFindStudentById()
    // {
    //     String studentName = "Javid Sadigli", studentGender = "Male";
    //     Long studentId = 1L; 

    //     StudentEntity mockStudentEntity = new StudentEntity(studentName, studentGender);
    //     mockStudentEntity.setId(studentId);

    //     Mockito.when(studentRepository.findById(studentId)).thenReturn(Optional.of(mockStudentEntity));

    //     StudentDTO result = this.studentService.findStudentById(studentId); 

    //     assertEquals(studentId, result.getId());
    //     assertEquals(studentName, result.getName());
    //     assertEquals(studentGender, result.getGender());
    // }
    
    // @Test
    // @DisplayName("Testing of findStudentById method with non-existent id")
    // public void testFindStudentByIdNullId()
    // {
    //     assertThrows(
    //         NullPointerException.class, 
    //         () -> {
    //             StudentDTO result = this.studentService.findStudentById(-1L); 
    //         }
    //     ); 
    // }

    // @Test
    // @DisplayName("Testing of saveStudent method")
    // public void testSaveStudent()
    // {
    //     String studentName = "Javid Sadigli", studentGender = "Male";
    //     Long studentId = 1L; 
    //     StudentDTO mockStudentDTO = new StudentDTO(studentId, studentName, studentGender);
    // }
    
}
