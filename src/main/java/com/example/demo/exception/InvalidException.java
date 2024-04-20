package com.example.demo.exception;

import lombok.Getter;

@Getter
public class InvalidException extends RuntimeException{
    private final ErrorResponse error;
    public InvalidException(ErrorResponse error) {
        this.error = error;
    }
}
