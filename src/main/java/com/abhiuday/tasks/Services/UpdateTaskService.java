package com.abhiuday.tasks.Services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Exceptions.TaskNotFoundException;
import com.abhiuday.tasks.Interfaces.Command;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Models.UpdateCommand;
import com.abhiuday.tasks.Repository.TasksRepository;
import com.abhiuday.tasks.Validators.TaskValidator;

@Service
public class UpdateTaskService implements Command<UpdateCommand, TaskDTO>{

    private final TasksRepository tasksRepository;

    public UpdateTaskService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }
    
    @Override
    public ResponseEntity<TaskDTO> execute(UpdateCommand input){
        Optional<Task> optionalTask = tasksRepository.findById(input.getId());
        if (optionalTask.isPresent()) {
            TaskValidator.validate(input.getTask());
            Task task = input.getTask();
            task.setId(input.getId());
            tasksRepository.save(task);
            return ResponseEntity.ok(new TaskDTO(task));
        }

        throw new TaskNotFoundException();
    }
}
