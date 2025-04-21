package com.abhiuday.tasks.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Models.UpdateCommand;
import com.abhiuday.tasks.Services.CreateTaskService;
import com.abhiuday.tasks.Services.DeleteTaskService;
import com.abhiuday.tasks.Services.GetTasksService;
import com.abhiuday.tasks.Services.UpdateTaskService;

@RestController
public class TaskController {

    private final CreateTaskService createTaskService;
    private final DeleteTaskService deleteTaskService;
    private final GetTasksService getTasksService;
    private final UpdateTaskService updateTaskService;

    public TaskController(CreateTaskService createTaskService,
                            DeleteTaskService deleteTaskService,
                            GetTasksService getTasksService,
                            UpdateTaskService updateTaskService){
        
        this.createTaskService = createTaskService;
        this.deleteTaskService = deleteTaskService;
        this.getTasksService = getTasksService;
        this.updateTaskService = updateTaskService;
    
    }
    
    @PostMapping
    public ResponseEntity<TaskDTO> CreateTask(@RequestBody Task task){
        return createTaskService.execute(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> GetTask(){
        return getTasksService.execute(null);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> UpdateTask(@PathVariable Integer id, @RequestBody Task task){
        return updateTaskService.execute(new UpdateCommand(id, task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> DeleteTask(@PathVariable Integer id){
        return deleteTaskService.execute(id);
    }
}
