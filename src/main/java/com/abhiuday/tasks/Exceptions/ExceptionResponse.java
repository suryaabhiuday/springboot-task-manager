package com.abhiuday.tasks.Exceptions;

import lombok.Getter;

@Getter
public class ExceptionResponse {
    private final String message;

    public ExceptionResponse(String message){
        this.message = message;
    }

}
