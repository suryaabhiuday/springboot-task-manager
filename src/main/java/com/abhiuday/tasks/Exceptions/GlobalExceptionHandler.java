package com.abhiuday.tasks.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ResponseBody
    @ExceptionHandler(TaskNotFoundException.class)
    public ExceptionResponse HandleTaskNotFoundException(TaskNotFoundException exception){
        return new ExceptionResponse(exception.getMessage());
    }
}
