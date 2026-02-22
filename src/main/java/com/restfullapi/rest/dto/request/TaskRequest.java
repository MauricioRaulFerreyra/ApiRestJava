package com.restfullapi.rest.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TaskRequest {

    // private Long id;
    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 100)
    private String title;

    @Size(max = 255)
    private String description;

    public TaskRequest() {
        // Constructor VACÍO OBLIGATORIO PARA SPRING
    }
    
    public TaskRequest(String title, String description) {
        
        this.title = title;
        this.description = description;
    }
    /*
    public Long getId() {
        return id;
    }
	*/
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}

