package com.Verinite.StudentConsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class Controller {
    @Autowired
    StudentService studentService;
    @Autowired
    StudentServiceImp studentServiceImp;

    @PostMapping("/Consumer")
    public StudentDto ConsumerController(@RequestBody StudentDto studentDto ){
 StudentDto studentDto1=studentService.saveStudent(studentDto);
 log.info("entering service B");
System.out.println(studentDto1);
studentServiceImp.sendMessage("student-service-async-topic",studentDto1.toString());
return studentDto1;

    }

}
