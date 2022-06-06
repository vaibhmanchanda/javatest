package com.example.javatest.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;


public class BadRequestException extends  Exception{

    public BadRequestException(String message){
        super(message);
    }
}
