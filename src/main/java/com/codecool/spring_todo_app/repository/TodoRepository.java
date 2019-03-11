package com.codecool.spring_todo_app.repository;

import com.codecool.spring_todo_app.model.Status;
import com.codecool.spring_todo_app.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {


    @Query("SELECT t from Todo t ORDER BY id")
    List<Todo> getAllTodos();

    List<Todo> getAllByStatusOrderById(Status status);

    Todo findById(long id);
}

