package com.Verinite.StudentProducer;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class StudentProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentProducerApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	@Bean
	public ModelMapper modalMapper(){
		return new ModelMapper();
	}

}
