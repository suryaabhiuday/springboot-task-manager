package com.abhiuday.tasks.Services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.abhiuday.tasks.Interfaces.Query;
import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Repository.TasksRepository;

@Service
public class SearchTaskService implements Query<String, List<TaskDTO>> {
    private final TasksRepository tasksRepository;

    public SearchTaskService(TasksRepository tasksRepository){
        this.tasksRepository = tasksRepository;
    }


    @Override
    public ResponseEntity<List<TaskDTO>> execute(String title){
        List<Task> tasks = tasksRepository.findByTitleContaining(title);

        List<TaskDTO> taskDTOs = tasks.stream().map(TaskDTO::new).toList();
        return ResponseEntity.ok(taskDTOs);
    }
}
