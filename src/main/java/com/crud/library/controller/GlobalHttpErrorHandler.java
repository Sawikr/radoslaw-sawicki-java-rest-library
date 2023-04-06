package com.crud.library.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalHttpErrorHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(LibraryNotFoundException.class)
    public ResponseEntity<Object> handleTaskNotFoundException(LibraryNotFoundException exception) {
        return new ResponseEntity<>("Task with given id doesn't exist!", HttpStatus.BAD_REQUEST);
    }
}
