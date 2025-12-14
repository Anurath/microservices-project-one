package com.ima.rating.RatingService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Map<String,Object>> resourceNotFoundException(ResourceNotFoundException ex)
    {
        Map<String,Object> map = new HashMap<>();

        map.put("status", HttpStatus.NOT_FOUND);
        map.put("message",ex.getMessage());
        map.put("success",true);

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
    }
}
