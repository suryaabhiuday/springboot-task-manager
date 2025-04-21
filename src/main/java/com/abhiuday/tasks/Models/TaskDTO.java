package com.abhiuday.tasks.Models;

import lombok.Data;

@Data
public class TaskDTO {
    
    private Integer id;
    private String description;
    private boolean completed;

    // Constructor with all fields
    public TaskDTO(Task task) {
        this.id = task.getId();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }
}
