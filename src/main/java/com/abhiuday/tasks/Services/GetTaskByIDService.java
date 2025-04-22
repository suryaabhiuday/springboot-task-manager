package com.abhiuday.tasks.Services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Exceptions.TaskNotFoundException;
import com.abhiuday.tasks.Interfaces.Command;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Repository.TasksRepository;

@Service
public class GetTaskByIDService implements Command<Integer, TaskDTO> {

    private final TasksRepository tasksRepository;

    public GetTaskByIDService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    @Override
    public ResponseEntity<TaskDTO> execute(Integer input){
        Optional<Task> optionalTask = tasksRepository.findById(input);

        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            return ResponseEntity.ok(new TaskDTO(task));
        }
        
        throw new TaskNotFoundException();
    }
}
