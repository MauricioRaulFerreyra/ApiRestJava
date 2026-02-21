package com.restfullapi.rest.mapper;

import com.restfullapi.rest.dto.request.TaskRequest;
import com.restfullapi.rest.dto.response.TaskResponse;
import com.restfullapi.rest.model.Task;

public class TaskMapper {

    public static Task toEntity(TaskRequest request) {
        Task task = new Task();
        task.setTitle(request.getTitle());
        task.setDescription(request.getDescription());
        return task;
    }

    public static TaskResponse toResponse(Task task) {
        return new TaskResponse(
                task.getId(),
                task.getTitle(),
                task.getDescription()
        );
    }
}
