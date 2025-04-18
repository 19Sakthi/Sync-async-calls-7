package com.Verinite.StudentConsumer.service;

import com.Verinite.StudentConsumer.dto.StudentDto;
import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

}
