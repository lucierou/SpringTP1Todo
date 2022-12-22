package com.example.tp1Todo.controller;

import com.example.tp1Todo.entity.Todo;
import com.example.tp1Todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/test")
    public String test() {
        return "test ok";
    }

    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo) {
        todoService.create(todo);
        return todo;
    }
}
