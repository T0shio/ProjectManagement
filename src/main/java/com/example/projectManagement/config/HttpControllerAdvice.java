package com.example.projectManagement.config;

import com.example.projectManagement.exceptions.HttpException;
import com.example.projectManagement.models.exceptions.HttpExceptionDTO;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpControllerAdvice {
    @ExceptionHandler(value = {HttpException.class})
    public ResponseEntity<HttpExceptionDTO> httpExceptionHandler(HttpException exception) {
        return new ResponseEntity<>(exception.getException(), HttpStatusCode.valueOf(exception.getException().getStatus()));
    }
}
