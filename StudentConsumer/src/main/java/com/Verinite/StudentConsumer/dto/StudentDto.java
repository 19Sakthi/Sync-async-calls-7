package com.Verinite.StudentConsumer.dto;

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
