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

    @PostMapping("/update/{id}")
    public String updateTodo(@PathVariable("id") Integer id, @RequestBody Todo newTodo) {
        Todo todo = todoService.findById(id);

        if (todo != null) {
            todo.setTitle(newTodo.getTitle());
            todo.setDescription(newTodo.getDescription());
            todo.setDate(newTodo.getDate());
            todo.setIsDone(newTodo.getIsDone());
            Boolean b = todoService.update(todo);
            if (b) {
                return "La todo avec l'id " + id + " a été modifiée : " + todo;
            }
        }
        return "Modification impossible";
    }

    @PostMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Integer id) {
        Todo todo = todoService.findById(id);
        Boolean b = todoService.delete(todo);
        if (b) {
            return "Todo avec l'id " + id + " supprimée";
        }
        return "Suppression impossible: pas de todo avec cet id";
    }

    @PostMapping("/toggleIsDone/{id}")
    public String toggleTodoIsDone(@PathVariable("id") Integer id) {
        Todo todo = todoService.findById(id);

        if (todo != null) {
            todo.setIsDone(!todo.getIsDone());
            Boolean b = todoService.update(todo);
            if (b) {
                return "L'état du todo avec l'id " + id + " a été modifié : " + todo;
            }
        }
        return "Modification impossible";
    }



}
