package com.verinite.StudentKafha;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class StudentKafhaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentKafhaApplication.class, args);
	}
	@Bean
	public ModelMapper modalMapper(){
		return new ModelMapper();
	}
}
