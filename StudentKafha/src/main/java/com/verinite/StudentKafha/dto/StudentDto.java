package com.verinite.StudentKafha.dto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
public class StudentDto {

    int studentId;
    String studentName;
    String studentEmail;
}
