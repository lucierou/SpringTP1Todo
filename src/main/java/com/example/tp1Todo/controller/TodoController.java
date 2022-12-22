package com.example.tp1Todo.controller;

import com.example.tp1Todo.entity.Todo;
import com.example.tp1Todo.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@ResponseBody
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping("/alltodos")
    public List<Todo> findAllTodos() {
        return todoService.findAll();
    }

    @GetMapping("/{id}")
    public Todo findById(@PathVariable Integer id) {
        return todoService.findById(id);
    }



    @PostMapping("/create")
    public Todo createTodo(@RequestBody Todo todo) {
        Boolean b = todoService.create(todo);
        if (b) {
            return todo;
        }
        return null;
    }





}
