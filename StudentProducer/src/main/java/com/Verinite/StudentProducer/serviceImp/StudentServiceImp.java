package com.Verinite.StudentProducer.serviceImp;

import com.Verinite.StudentProducer.dto.StudentDto;
import com.Verinite.StudentProducer.entity.StudentEntity;
import com.Verinite.StudentProducer.repo.StudentRepo;
import com.Verinite.StudentProducer.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import lombok.extern.slf4j.Slf4j;
@Service
public class StudentServiceImp implements StudentService {
@Autowired
    StudentRepo studentRepo;
@Autowired
    ModelMapper modelMapper;
    @Override
    public StudentDto save(StudentDto studentDto) {
       StudentEntity studentEntity= studentRepo.save(ConvertDtoTOEntity(studentDto));
        return ConvertEntityToDto(studentEntity);
    }
    public StudentEntity ConvertDtoTOEntity(StudentDto studentDto){
   return modelMapper.map(studentDto,StudentEntity.class);
    }

    public StudentDto ConvertEntityToDto(StudentEntity studentEntity){
        return modelMapper.map(studentEntity,StudentDto.class);
    }
}
