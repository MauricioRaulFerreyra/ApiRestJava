package com.restfullapi.rest.entity;

import jakarta.persistence.Entity;

@Entity
public class Task {

	private Long id;
    private String title;
    private String description;

}
