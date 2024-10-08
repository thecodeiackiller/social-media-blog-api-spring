package com.example.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {
    
   @ExceptionHandler(IllegalArgumentException.class)
   public ResponseEntity<String> illegalArgHandler(IllegalArgumentException ex)
   {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getMessage());
   }

   @ExceptionHandler(Exception.class)
   public ResponseEntity<String> statusCode400Response(Exception ex)
   {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
   }     
}
