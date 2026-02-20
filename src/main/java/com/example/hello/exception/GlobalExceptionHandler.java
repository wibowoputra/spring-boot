package com.example.hello.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.hello.dto.ErrorResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse("Invalid input: " + ex.getMessage(), 400, "Bad Request");
        return ResponseEntity.status(400).body(errorResponse);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGeneralException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse("An unexpected error occurred: " + ex.getMessage(), 500, "Internal Server Error");
        return ResponseEntity.status(500).body(errorResponse);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity<Map<String, String>> handleValidationErrors(
                MethodArgumentNotValidException ex) {

            Map<String, String> errors = new HashMap<>();
            ex.getBindingResult()
            .getFieldErrors()
            .forEach(err -> errors.put(err.getField(), err.getDefaultMessage()));

            return ResponseEntity.badRequest().body(errors);
        }
}
