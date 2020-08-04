package com.memory.Journal.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {

    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<String> onUserNotFound(UserNotFoundException userNotFoundException) {
        return new ResponseEntity<>("User not found", HttpStatus.NOT_FOUND);
    }
}
