package com.restfullapi.rest.controller;

import com.restfullapi.rest.model.Task;
import com.restfullapi.rest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TodoController {


    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String holamundo(){
        return "Hola Mundo";
    }

    @GetMapping
    public  ResponseEntity<List<Task>> getTasks(){
        return ResponseEntity.ok(todoRepository.findAll());
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task){
    	Task savedTask = todoRepository.save(task);
        todoRepository.save(task);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedTask);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updatedTask(@PathVariable Long id,@RequestBody Task task){
        return todoRepository.findById(id)
        		.map(existingTask -> {
        			existingTask.setTitle(task.getTitle());
        			existingTask.setDescription(task.getDescription());
        			Task updated = todoRepository.save(existingTask);
        			return ResponseEntity.ok(updated);
        		})
        		.orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable Long id){
    	
    	return todoRepository.findById(id)
				.map(task -> {
					todoRepository.delete(task);
					return ResponseEntity.noContent().<Void>build();
				})
				.orElse(ResponseEntity.notFound().build());
    }
    
}
    
    
    