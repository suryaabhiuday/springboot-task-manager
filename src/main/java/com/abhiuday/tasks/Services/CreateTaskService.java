package com.abhiuday.tasks.Services;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Interfaces.Command;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Repository.TasksRepository;
import com.abhiuday.tasks.Validators.TaskValidator;

@Service
public class CreateTaskService implements Command<Task, TaskDTO>{

    private final TasksRepository tasksRepository;

    public CreateTaskService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Task input){
        TaskValidator.validate(input);
        Task newTask = tasksRepository.save(input);
        return ResponseEntity.status(HttpStatus.CREATED).body(new TaskDTO(newTask));
    } 
}
