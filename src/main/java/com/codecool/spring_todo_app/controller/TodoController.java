package com.codecool.spring_todo_app.controller;

import com.codecool.spring_todo_app.model.Status;
import com.codecool.spring_todo_app.model.Todo;
import com.codecool.spring_todo_app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class TodoController {

    private static final String SUCCESS = "{\"success\":true}";

    @Autowired
    TodoRepository todoRepository;

    @PostMapping("/list")
    public String listTodos(@RequestParam Map<String,String> params) throws Exception {

        String status = params.get("status");
        List<Todo> todosToReturn;

        if (status == null || status.isEmpty()) {

            todosToReturn = todoRepository.getAllTodos();
            System.out.println(todosToReturn);
        } else {

            todosToReturn = todoRepository.getAllByStatus(status);
        }
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

    @PostMapping("/addTodo")
    public String addTodo(@RequestParam Map<String, String> params) {

        String title = params.get("todo-title");
        Todo todo = Todo.builder()
                .title(title)
                .status(Status.ACTIVE)
                .build();

        todoRepository.saveAndFlush(todo);
        return SUCCESS;

    }

    @PutMapping("/todos/{id}/toggle_status")
    public String toggleStatus(@PathVariable("id") long id, @RequestParam Map<String, String> params) {
        boolean completed = params.get("status").equals("true");
        Todo todo = todoRepository.findById(id);
        todo.toggleStatus(completed);
        todoRepository.save(todo);
        return SUCCESS;
    }


}
