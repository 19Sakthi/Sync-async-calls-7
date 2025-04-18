package com.Verinite.StudentConsumer.exception;


import com.Verinite.StudentConsumer.utility.ResponseInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandler {
    @Autowired
    ResponseInfo responseInfo;
    @org.springframework.web.bind.annotation.ExceptionHandler(NullPointerException.class)

    public ResponseEntity<ResponseInfo> nullPointerException(NullPointerException nullPointerException){
        responseInfo.setMessage("Null values  detected");
        responseInfo.setStatus(String.valueOf(HttpStatus.BAD_REQUEST));
        return new ResponseEntity<ResponseInfo>(responseInfo,HttpStatus.OK);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseInfo> httpServerErrorException(DataIntegrityViolationException httpClientErrorException){
        responseInfo.setMessage("Duplicated value found");
        responseInfo.setStatus(String.valueOf(HttpStatus.BAD_GATEWAY));
        return new ResponseEntity<ResponseInfo>(responseInfo,HttpStatus.OK);
    }
}
