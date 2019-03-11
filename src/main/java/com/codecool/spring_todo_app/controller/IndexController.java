package com.codecool.spring_todo_app.controller;

import com.codecool.spring_todo_app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @Autowired
    TodoRepository todoRepository;

    @GetMapping("/index")
    public String welcome() {

        return "index";

    }





}
