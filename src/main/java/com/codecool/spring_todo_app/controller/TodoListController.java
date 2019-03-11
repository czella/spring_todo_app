package com.codecool.spring_todo_app.controller;

import com.codecool.spring_todo_app.model.Todo;
import com.codecool.spring_todo_app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

@RestController
public class TodoListController {

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/list")
    public String listTodos(@RequestParam Map<String,String> params) throws Exception {

        String status = params.get("status");
        List<Todo> todosToReturn = null;

        if (status != null) {

            todosToReturn = todoRepository.findAll();
            JSONArray arr = new JSONArray();
            for (Todo todo : todosToReturn) {
                JSONObject jo = new JSONObject();
                jo.put("id", todo.getId());
                jo.put("title", todo.getTitle());
                jo.put("completed", todo.isComplete());
                arr.put(jo);
            }
            return arr.toString(2);
        }

        return null;


    }

}
