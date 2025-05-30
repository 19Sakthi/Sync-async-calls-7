package com.Verinite.StudentConsumer.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class StudentEntity {
    @Id
    @GeneratedValue
    int studentId;
    String studentName;
    String studentEmail;
}
