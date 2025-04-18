package com.verinite.StudentKafha.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.verinite.StudentKafha.service.Service;
import com.verinite.StudentKafha.dto.StudentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Controller {

    @Autowired
    Service service;


    @KafkaListener(topics = "student-service-async-topic")
    public void consumerFromKafha(String message) throws JsonProcessingException {
        log.info("Received message from Kafka topic 'student-service-async-topic': {}", message);
        ObjectMapper objectMapper = new ObjectMapper();
        StudentDto studentDto = objectMapper.readValue(message, StudentDto.class);
        log.debug("Converted message to StudentDto: {}", studentDto);
        service.saveStudent(studentDto);
        log.info("Saved student: {}", studentDto);
    }
}
