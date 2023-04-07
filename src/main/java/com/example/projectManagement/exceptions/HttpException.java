package com.example.projectManagement.exceptions;

import com.example.projectManagement.models.exceptions.HttpExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public abstract class HttpException extends RuntimeException {
    private HttpExceptionDTO exception;

    public HttpException(HttpStatus status, String message) {
        super(message);
        exception = HttpExceptionDTO.builder()
                .status(status.value())
                .message(message)
                .build();
    }
}