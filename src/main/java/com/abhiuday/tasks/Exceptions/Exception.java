package com.abhiuday.tasks.Exceptions;

import lombok.Getter;

@Getter
public enum Exception {
    TASK_NOT_FOUND("Task not found");

    private final String message;

    Exception(String message){
        this.message = message;
    }
}
