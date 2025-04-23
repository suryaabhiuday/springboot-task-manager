package com.abhiuday.tasks.Controller;

import org.springframework.web.bind.annotation.*;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;

import com.abhiuday.tasks.Models.Task;
import com.abhiuday.tasks.Models.TaskDTO;
import com.abhiuday.tasks.Models.UpdateCommand;
import com.abhiuday.tasks.Services.*;

@RestController
public class TaskController {

    private final CreateTaskService createTaskService;
    private final DeleteTaskService deleteTaskService;
    private final GetTasksService getTasksService;
    private final UpdateTaskService updateTaskService;
    private final GetTaskByIDService getTaskByIDService;
    private final SearchTaskService searchTaskService;

    public TaskController(CreateTaskService createTaskService,
                            DeleteTaskService deleteTaskService,
                            GetTasksService getTasksService,
                            UpdateTaskService updateTaskService,
                            GetTaskByIDService getTaskByIDService,
                            SearchTaskService searchTaskService){
        
        this.createTaskService = createTaskService;
        this.deleteTaskService = deleteTaskService;
        this.getTasksService = getTasksService;
        this.getTaskByIDService = getTaskByIDService;
        this.updateTaskService = updateTaskService;
        this.searchTaskService = searchTaskService;
    }
    
    @PostMapping
    public ResponseEntity<TaskDTO> CreateTask(@RequestBody Task task){
        return createTaskService.execute(task);
    }

    @GetMapping
    public ResponseEntity<List<Task>> GetTask(){
        return getTasksService.execute(null);
    }

    @GetMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> GetTaskByID(@PathVariable Integer id){
        return getTaskByIDService.execute(id);
    }

    @PutMapping("/tasks/{id}")
    public ResponseEntity<TaskDTO> UpdateTask(@PathVariable Integer id, @RequestBody Task task){
        return updateTaskService.execute(new UpdateCommand(id, task));
    }

    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<Void> DeleteTask(@PathVariable Integer id){
        return deleteTaskService.execute(id);
    }

    @Query
    @GetMapping("/tasks/search")
    public ResponseEntity<List<TaskDTO>> SearchTaskByName(@RequestParam String title){
        return searchTaskService.execute(title);
    }
}
