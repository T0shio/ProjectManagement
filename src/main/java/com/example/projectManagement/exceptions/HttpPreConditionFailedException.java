package com.example.projectManagement.exceptions;

import com.example.projectManagement.models.exceptions.HttpExceptionDTO;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class HttpPreConditionFailedException extends HttpException {
    private final List<FieldError> errors;

    public HttpPreConditionFailedException(String message, List<FieldError> fieldErrors) {
        super(HttpStatus.PRECONDITION_FAILED, message);
        this.errors = fieldErrors;
    }

    public HttpExceptionDTO getException() {
        return HttpExceptionDTO.builder()
                .status(HttpStatus.PRECONDITION_FAILED.value())
                .message(getMessage())
                .errors(this.errors.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage)))
                .build();
    }
}