package com.bokito.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

@ControllerAdvice
public class HandleProductException {
    @ExceptionHandler
    public ResponseEntity<MessageError> handleEmptyField(ProductException ex, WebRequest request){
        MessageError error= new MessageError();
        error.setTimestamp(new Date());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setError(HttpStatus.BAD_REQUEST.name());
        error.setMessage(ex.getMessage());
        return  new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
}
