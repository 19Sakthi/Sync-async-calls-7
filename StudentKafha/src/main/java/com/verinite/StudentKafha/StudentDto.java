package com.verinite.StudentKafha;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;
@Entity
@Data
public class StudentDto {
    @Id
            @GeneratedValue
    int studentId;
    String studentName;
    String studentEmail;
}
