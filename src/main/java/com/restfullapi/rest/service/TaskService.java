package com.restfullapi.rest.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.restfullapi.rest.dto.request.TaskRequest;
import com.restfullapi.rest.dto.response.TaskResponse;
import com.restfullapi.rest.mapper.TaskMapper;
import com.restfullapi.rest.model.Task;
import com.restfullapi.rest.repository.TodoRepository;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

	@Autowired
	private TodoRepository repository;
	
	// CREATE
	public TaskResponse create(TaskRequest request) {
		
		// DTO → Entity
        Task task = TaskMapper.toEntity(request);
        // GUARDAR EN DB
        Task saved = repository.save(task);
        // Entity → DTO
        return TaskMapper.toResponse(saved);
		
	}
	
	// READ ALL
	public List<TaskResponse> getAll(){
		
		return repository.findAll()
				.stream()
				.map(TaskMapper::toResponse)
				.collect(Collectors.toList());
	}
	
	// READ BY ID
	public TaskResponse getById(Long id) {
		
		Task task = repository.findById(id)
				.orElseThrow(() ->
			    new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));
		
		return TaskMapper.toResponse(task);
	}
	
	// UPDATE
	public TaskResponse update(Long id, TaskRequest request) {
		
		Task task = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Task not found"));
		
		task.setTitle(request.getTitle());
		task.setDescription(request.getDescription());
		
		Task updated = repository.save(task);
		
		return TaskMapper.toResponse(updated);
	}
	
	// DELETE
	public void delete (Long id) {
		
		Task task = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Task not found"));
		
		repository.delete(task);
	}
	
}






