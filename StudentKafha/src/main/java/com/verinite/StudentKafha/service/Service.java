package com.verinite.StudentKafha.service;

import com.verinite.StudentKafha.dto.StudentDto;

@org.springframework.stereotype.Service
public interface Service {
    StudentDto saveStudent(StudentDto studentDto);
}
