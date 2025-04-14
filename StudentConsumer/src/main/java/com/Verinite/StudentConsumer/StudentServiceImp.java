package com.Verinite.StudentConsumer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImp implements StudentService {
    @Autowired
    StudentRepo studentRepo;
    @Autowired
    ModelMapper modelMapper;

    private final KafkaTemplate<String, String> kafkaTemplate;

    public StudentServiceImp(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        StudentEntity studentEntity= studentRepo.save(ConvertDtoTOEntity(studentDto));
        return ConvertEntityToDto(studentEntity);
    }

    public void sendMessage(String topic,String studentDto) {
       // log.info("Sending message='{}' to topic='{}'", message, topic);
        kafkaTemplate.send(topic,studentDto);
    }


    public StudentEntity ConvertDtoTOEntity(StudentDto studentDto){
        return modelMapper.map(studentDto,StudentEntity.class);
    }

    public StudentDto ConvertEntityToDto(StudentEntity studentEntity){
        return modelMapper.map(studentEntity,StudentDto.class);
    }
}

