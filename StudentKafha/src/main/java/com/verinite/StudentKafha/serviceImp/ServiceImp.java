package com.verinite.StudentKafha.serviceImp;

import com.verinite.StudentKafha.dto.StudentDto;
import com.verinite.StudentKafha.entity.StudentEntity;
import com.verinite.StudentKafha.repo.StudentRepo;
import com.verinite.StudentKafha.service.Service;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

@Slf4j
@org.springframework.stereotype.Service
public class ServiceImp implements Service {

    @Autowired
    private StudentRepo studentRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public StudentDto saveStudent(StudentDto studentDto) {
        log.info("Entering saveStudent method with StudentDto: {}", studentDto);

        StudentDto responseDto = null;
        try {
            StudentEntity studentEntity = studentRepo.save(ConvertDtoTOEntity(studentDto));
            log.info("Student saved successfully with ID: {}", studentEntity.getStudentId());
            responseDto = ConvertEntityToDto(studentEntity);
            log.info("Returning saved StudentDto: {}", responseDto);

        } catch (Exception e) {
            log.error("Error occurred while saving student: {}", studentDto, e);
        }

        log.info("Exiting saveStudent method with response: {}", responseDto);
        return responseDto;
    }


    public StudentEntity ConvertDtoTOEntity(StudentDto studentDto) {
        log.debug("Entering ConvertDtoTOEntity method with StudentDto: {}", studentDto);
        StudentEntity studentEntity = modelMapper.map(studentDto, StudentEntity.class);
        log.debug("Exiting ConvertDtoTOEntity method with StudentEntity: {}", studentEntity);
        return studentEntity;
    }


    public StudentDto ConvertEntityToDto(StudentEntity studentEntity) {
        log.debug("Entering ConvertEntityToDto method with StudentEntity: {}", studentEntity);
        StudentDto studentDto = modelMapper.map(studentEntity, StudentDto.class);
        log.debug("Exiting ConvertEntityToDto method with StudentDto: {}", studentDto);
        return studentDto;
    }
}
