package com.abhiuday.tasks.Exceptions;

import lombok.Getter;

@Getter
public enum Exception {
    TASK_NOT_FOUND("Task not found"),
    NO_TITLE("Title is required"),
    TITLE_LENGTH_EXCEEDED("Title must be under 100 characters"),
    DUE_DATE_IN_PAST("Due date cannot be in the past"),
    INVAILD_PRIORITY("Priority must be LOW, MEDIUM, or HIGH");

    private final String message;

    Exception(String message){
        this.message = message;
    }
}
