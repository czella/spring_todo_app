package com.codecool.spring_todo_app.controller;

import com.codecool.spring_todo_app.model.Todo;
import com.codecool.spring_todo_app.repository.TodoRepository;
import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;


import java.util.List;

import static org.junit.Assert.assertEquals;


public class TodoListControllerTest {


    @InjectMocks
    TodoController todoListController;

    @Mock
    TodoRepository todoRepository;

    @Mock
    List<Todo> todoList;

    @Before
    public void initMocks() {

        MockitoAnnotations.initMocks(this);

    }



}
