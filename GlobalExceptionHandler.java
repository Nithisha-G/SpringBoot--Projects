package com.example.demo.Exception;



import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(StudentNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleStudentNotFound(
            StudentNotFoundException ex) {

        return ex.getMessage();
    }
}