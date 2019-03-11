package com.codecool.spring_todo_app.controller;

import com.codecool.spring_todo_app.model.Todo;
import com.codecool.spring_todo_app.repository.TodoRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import static org.junit.Assert.assertEquals;


public class TodoListControllerTest {


    @InjectMocks
    TodoListController todoListController;

    @Mock
    TodoRepository todoRepository;

    @Mock
    List<Todo> todoList;

    @Before
    public void initMocks() {

        MockitoAnnotations.initMocks(this);

    }



}
