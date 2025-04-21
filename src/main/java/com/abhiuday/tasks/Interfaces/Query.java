package com.abhiuday.tasks.Interfaces;

import org.springframework.http.ResponseEntity;

public interface Query<Input, Output> {

    ResponseEntity<Output> execute(Input input);

}
