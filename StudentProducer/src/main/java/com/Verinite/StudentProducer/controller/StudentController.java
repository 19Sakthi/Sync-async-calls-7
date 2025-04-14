package com.Verinite.StudentProducer.controller;

import com.Verinite.StudentProducer.dto.StudentDto;
import com.Verinite.StudentProducer.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController

public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    private RestTemplate restTemplate;


    @PostMapping("/saveStudent")
    public StudentDto saveController(@RequestBody StudentDto studentDto){
        System.out.println("Form StudentProducer Controller");
        studentService.save(studentDto);
        return restTemplate.postForObject("http://localhost:8890/Consumer",studentDto,StudentDto.class);
    }
}