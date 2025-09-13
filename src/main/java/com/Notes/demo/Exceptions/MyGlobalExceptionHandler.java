package com.Notes.demo.Exceptions;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class MyGlobalExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String,String>> myConstraintViolationException(ConstraintViolationException  e){
        Map<String, String> response = new HashMap<>();

       e.getConstraintViolations().forEach(constraint ->{
        String fieldName = constraint.getPropertyPath().toString();
        String message = constraint.getMessage();
        response.put(fieldName, message);
       });

       return new ResponseEntity<Map<String,String>>(response, HttpStatus.BAD_REQUEST);
        

    }

    @ExceptionHandler(APIExceptions.class)
    public ResponseEntity<String> myAPIException(APIExceptions e){
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFound.class)
    public ResponseEntity<String> myResourceNotFound(ResourceNotFound e){
        String message = e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }


    
}
