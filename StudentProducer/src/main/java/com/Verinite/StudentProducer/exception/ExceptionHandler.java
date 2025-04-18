package com.Verinite.StudentProducer.exception;


import com.Verinite.StudentProducer.utility.ResponseInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

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
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpClientErrorException.class)
  public ResponseEntity<ResponseInfo> httpClientErrorException(HttpClientErrorException httpClientErrorException){
        responseInfo.setMessage("Url unformated");
        responseInfo.setStatus(String.valueOf(HttpStatus.BAD_GATEWAY));
        return new ResponseEntity<ResponseInfo>(responseInfo,HttpStatus.OK);
    }
    @org.springframework.web.bind.annotation.ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ResponseInfo> httpServerErrorException(HttpServerErrorException httpClientErrorException){
        responseInfo.setMessage("internal server error");
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
