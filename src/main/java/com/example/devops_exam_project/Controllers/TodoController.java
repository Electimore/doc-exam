package com.example.devops_exam_project.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.devops_exam_project.Entities.Todo;
import com.example.devops_exam_project.Repositories.TodoRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    @Autowired
    private TodoRepository todoRepository;

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        todo.setCreated(new Date());
        return todoRepository.save(todo);
    }
}