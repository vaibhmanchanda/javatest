package com.example.javatest.exception;

import com.example.javatest.dto.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExecptionHandler {

    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse handleException(final BadRequestException badRequestException) {
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(),badRequestException.getMessage());
    }
}
