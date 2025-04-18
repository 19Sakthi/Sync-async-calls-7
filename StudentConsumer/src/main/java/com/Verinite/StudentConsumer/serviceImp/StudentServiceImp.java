package com.Verinite.StudentConsumer.serviceImp;

import com.Verinite.StudentConsumer.dto.StudentDto;
import com.Verinite.StudentConsumer.entity.StudentEntity;
import com.Verinite.StudentConsumer.repo.StudentRepo;
import com.Verinite.StudentConsumer.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;


    public StudentServiceImp(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        log.info("Received request to save student: {}", studentDto);
        StudentEntity studentEntity = studentRepo.save(ConvertDtoTOEntity(studentDto));
        log.info("Student saved successfully with ID: {}", studentEntity.getStudentId());
        try {
            kafkaTemplate.send("student-service-async-topic", studentDto.toString());
            log.info("Student data sent to Kafka topic 'student-service-async-topic': {}", studentDto);
        } catch (Exception e) {
            log.error("Error occurred while sending student data to Kafka", e);
        }
        return ConvertEntityToDto(studentEntity);
    }


    public StudentEntity ConvertDtoTOEntity(StudentDto studentDto) {
        log.debug("Converting StudentDto to StudentEntity: {}", studentDto);
        return modelMapper.map(studentDto, StudentEntity.class);
    }


    public StudentDto ConvertEntityToDto(StudentEntity studentEntity) {
        log.debug("Converting StudentEntity to StudentDto: {}", studentEntity);
        return modelMapper.map(studentEntity, StudentDto.class);
    }
}
