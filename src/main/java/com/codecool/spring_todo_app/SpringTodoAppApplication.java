package com.codecool.spring_todo_app;

import com.codecool.spring_todo_app.model.Status;
import com.codecool.spring_todo_app.model.Todo;
import com.codecool.spring_todo_app.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class SpringTodoAppApplication {

    public static void main(String[] args) { SpringApplication.run(SpringTodoAppApplication.class, args);}

    @Autowired
    TodoRepository todoRepository;

    @Bean
    @Profile("production")
    public CommandLineRunner init() {

        return args -> {
            Todo todo = Todo.builder()
                    .status(Status.ACTIVE)
                    .title("First thing to do")
                    .build();

            Todo todo2 = Todo.builder()
                    .status(Status.ACTIVE)
                    .title("Second thing to do")
                    .build();

            Todo todo3 = Todo.builder()
                    .status(Status.ACTIVE)
                    .title("Third thing to do")
                    .build();

            todoRepository.saveAndFlush(todo);
            todoRepository.saveAndFlush(todo2);
            todoRepository.saveAndFlush(todo3);

        };

    }


}
