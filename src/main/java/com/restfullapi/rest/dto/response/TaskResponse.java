package com.restfullapi.rest.dto.response;

public class TaskResponse {

    private long id;
    private String title;
    private String description;

    // constructor
    public TaskResponse(long id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // getters
	public long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

}
