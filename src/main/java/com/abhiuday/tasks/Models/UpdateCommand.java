package com.abhiuday.tasks.Models;

import lombok.Getter;

@Getter
public class UpdateCommand {
    private Integer id;
    private Task task;

    public UpdateCommand(){}

    public UpdateCommand(Integer id, Task task){
        this.id = id;
        this.task = task;
    }
}
