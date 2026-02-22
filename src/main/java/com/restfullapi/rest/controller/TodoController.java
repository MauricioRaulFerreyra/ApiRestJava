package com.restfullapi.rest.controller;

import com.restfullapi.rest.dto.request.TaskRequest;
import com.restfullapi.rest.dto.response.TaskResponse;
import com.restfullapi.rest.service.TaskService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TodoController {


    @Autowired
    private TaskService taskService;

    @GetMapping
    public ResponseEntity<List<TaskResponse>> getTasks(){
        return ResponseEntity.ok(taskService.getAll());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<TaskResponse> getTask(
    		@PathVariable Long id ){
    	
        return ResponseEntity.ok(taskService.getById(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponse> createTask(
            @Valid @RequestBody TaskRequest request){

        TaskResponse response = taskService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TaskResponse> updateTask(
            @PathVariable Long id,
            @Valid @RequestBody TaskRequest request){

        return ResponseEntity.ok(taskService.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
}
    
    
    