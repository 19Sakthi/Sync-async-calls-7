package com.Verinite.StudentProducer.serviceImp;

import com.Verinite.StudentProducer.dto.StudentDto;
import com.Verinite.StudentProducer.entity.StudentEntity;
import com.Verinite.StudentProducer.repo.StudentRepo;
import com.Verinite.StudentProducer.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class StudentServiceImp implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        log.info("Saving student: {}", studentDto);


        StudentEntity studentEntity = ConvertDtoTOEntity(studentDto);
        studentRepo.save(studentEntity);
        log.info("Student saved successfully with ID: {}", studentEntity.getStudentId());


        StudentDto savedStudentDto = restTemplate.postForObject("http://localhost:8890/Consumer", studentDto, StudentDto.class);
        log.info("Student data forwarded to Consumer service, response: {}", savedStudentDto);

        return savedStudentDto;
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
