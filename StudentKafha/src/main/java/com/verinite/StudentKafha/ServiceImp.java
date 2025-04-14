package com.verinite.StudentKafha;

import org.springframework.beans.factory.annotation.Autowired;
@org.springframework.stereotype.Service
public class ServiceImp implements Service {
    @Autowired
    StudentRepo studentRepo;
    @Override
    public StudentDto saveStudent(StudentDto studentDto) {

        return studentRepo.save(studentDto);
    }
}
