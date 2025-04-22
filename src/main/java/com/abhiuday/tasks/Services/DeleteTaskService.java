package com.abhiuday.tasks.Services;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Exceptions.TaskNotFoundException;
import com.abhiuday.tasks.Interfaces.Command;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Repository.TasksRepository;

@Service
public class DeleteTaskService implements Command<Integer, Void>{

    private final TasksRepository tasksRepository;

    public DeleteTaskService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Integer input) {
        Optional<Task> optionalTask = tasksRepository.findById(input);
        if (optionalTask.isPresent()) {
            tasksRepository.deleteById(input);
            return ResponseEntity.noContent().build();
        }
        throw new TaskNotFoundException();
    }
}
