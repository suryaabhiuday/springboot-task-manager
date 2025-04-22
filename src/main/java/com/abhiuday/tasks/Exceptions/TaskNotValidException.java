package com.abhiuday.tasks.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class TaskNotValidException extends RuntimeException{
    public TaskNotValidException(String message){
        super(message);
    }
}
