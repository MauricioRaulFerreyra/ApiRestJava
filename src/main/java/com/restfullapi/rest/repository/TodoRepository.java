package com.restfullapi.rest.repository;

import com.restfullapi.rest.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TodoRepository extends JpaRepository<Task,Long> {
}
