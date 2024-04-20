package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
@RestControllerAdvice
public class HandlerException {
    @ExceptionHandler(value = InvalidException.class)
    public ResponseEntity<?> handleInvalidRequest(InvalidException ex){
        return new ResponseEntity<>(ex.getError(), HttpStatus.BAD_REQUEST);
    }
}
