package com.abhiuday.tasks.Interfaces;

import org.springframework.http.ResponseEntity;

public interface Command<Input, Output> {
    ResponseEntity<Output> execute(Input input);
}
