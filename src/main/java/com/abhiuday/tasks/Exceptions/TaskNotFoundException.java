package com.abhiuday.tasks.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TaskNotFoundException extends RuntimeException{
    public TaskNotFoundException(){
        super(Exception.TASK_NOT_FOUND.getMessage());
    }
}
