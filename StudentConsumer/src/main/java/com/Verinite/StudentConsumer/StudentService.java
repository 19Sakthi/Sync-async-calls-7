package com.Verinite.StudentConsumer;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    StudentDto saveStudent(StudentDto studentDto);

}
