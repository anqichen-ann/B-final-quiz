package com.example.demo.exception;

import com.example.demo.dto.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFound.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Error handleResourceNotFound(ResourceNotFound ex){
        return new Error(ex.getMessage(), HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(ConstraintViolationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Error constraintHandle(ConstraintViolationException ex) {
        String message = "";
        for (ConstraintViolation<?> constraint : ex.getConstraintViolations()) {
            message = constraint.getMessage();
            break;
        }
        return new Error(message,HttpStatus.BAD_REQUEST.value());

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Error> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldError().getDefaultMessage();
        Error errorResult = new Error(message,HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResult);
    }



}
