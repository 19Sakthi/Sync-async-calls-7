package com.Verinite.StudentConsumer;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
public class StudentDto {
    int studentId;
    String studentName;
    String studentEmail;

    @Override
    public String toString() {
        return "{ \"studentName\": \"" + studentName  +
                "\", \"studentEmail\": \" " + studentEmail +
                "\"}";
    }
}
