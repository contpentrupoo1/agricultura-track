package com.agricultura.agricultura.track.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {NullPointerException.class})
    public ResponseEntity<Object> handleNullPointerException(Exception e) {
        return new ResponseEntity<>("Validarea a esuat din cauza lipsei unei valori", HttpStatus.BAD_REQUEST);
    }
}

