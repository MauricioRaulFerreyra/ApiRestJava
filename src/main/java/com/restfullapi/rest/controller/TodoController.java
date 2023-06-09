package com.restfullapi.rest.controller;

import com.restfullapi.rest.model.Task;
import com.restfullapi.rest.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TodoController {


    @Autowired
    private TodoRepository todoRepository;

    @GetMapping("/")
    public String holamundo(){
        return "Hola Mundo";
    }

    @GetMapping("/tasks")
    public List<Task> getTasks(){
        return todoRepository.findAll();
    }

    @PostMapping("/saveTasks")
    public String saveTask(@RequestBody Task task){
        todoRepository.save(task);
        return "save tasks";
    }

    @PutMapping("/updateTask/{id}")
    public String updatedTask(@PathVariable Long id,@RequestBody Task task){
        Task updateTask = todoRepository.findById(id).get();
        updateTask.setTitle(task.getTitle());
        updateTask.setDescription(task.getDescription());
        todoRepository.save((updateTask));
        return "update ok!!!";
    }

    @DeleteMapping("/deleteTask/{id}")
    public String deleteTask(@PathVariable Long id){
        Task deletedTask = todoRepository.findById(id).get();
        todoRepository.delete(deletedTask);
        return "deleted  task";
    }
}
