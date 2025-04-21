package com.abhiuday.tasks.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Interfaces.Query;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Repository.TasksRepository;

@Service
public class GetTasksService implements Query<Void, List<Task>>{
    
    private final TasksRepository tasksRepository;

    public GetTasksService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }
    
    @Override
    public ResponseEntity<List<Task>> execute(Void input) {
        List<Task> tasks = tasksRepository.findAll();
        return ResponseEntity.ok(tasks);
    }
}
