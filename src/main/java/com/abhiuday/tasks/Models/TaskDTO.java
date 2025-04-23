package com.abhiuday.tasks.Models;

import lombok.Data;

@Data
public class TaskDTO {
    
    private Integer id;
    private String title;
    private String description;
    private boolean completed;

    // Constructor with all fields
    public TaskDTO(Task task) {
        this.id = task.getId();
        this.title = task.getTitle();
        this.description = task.getDescription();
        this.completed = task.isCompleted();
    }
}
