package com.Verinite.StudentConsumer.controller;

import com.Verinite.StudentConsumer.dto.StudentDto;
import com.Verinite.StudentConsumer.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private StudentService studentService;

    @PostMapping("/Consumer")
    public StudentDto ConsumerController(@RequestBody StudentDto studentDto) {
        log.info("Received request to save student: {}", studentDto);
        StudentDto studentDto1 = studentService.saveStudent(studentDto);
        log.info("Student saved and response returned: {}", studentDto1);
        return studentDto1;
    }
}
