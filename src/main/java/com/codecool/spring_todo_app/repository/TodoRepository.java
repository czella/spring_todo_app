package com.codecool.spring_todo_app.repository;

import com.codecool.spring_todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    List<Todo> getAllByStatus(String status);


}
