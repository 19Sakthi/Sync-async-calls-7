package com.verinite.StudentKafha;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class Controller {
    @Autowired
    Service service;
    @KafkaListener(topics = "student-service-async-topic")
    public void consumerFormMessage(@RequestParam String message) throws JsonProcessingException {
        ObjectMapper objectMapper=new ObjectMapper();
        StudentDto studentDto=objectMapper.readValue(message,StudentDto.class);
        service.saveStudent(studentDto);
        System.out.println("Received data from order-service : "+studentDto );
    }

}
