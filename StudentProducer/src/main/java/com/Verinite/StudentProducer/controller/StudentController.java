package com.Verinite.StudentProducer.controller;

import com.Verinite.StudentProducer.dto.StudentDto;
import com.Verinite.StudentProducer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/saveStudent")
    public StudentDto producerController(@RequestBody StudentDto studentDto){
        log.info("Received request to save student: {}", studentDto);

        try {
            studentService.saveStudent(studentDto);
            log.info("Student saved successfully: {}", studentDto);
        } catch (Exception e) {
            log.error("Error occurred while saving student: {}", studentDto, e);
            throw e;
        }

        return studentDto;
    }
}
