package com.example.devops_exam_project.Controllers;

import org.springframework.web.bind.annotation.*;

import com.example.devops_exam_project.Entities.Todo;
import com.example.devops_exam_project.Repositories.TodoRepository;

import java.util.List;

@RestController
@RequestMapping("/todo")
public class TodoController {

    private final TodoRepository todoRepository;

    public TodoController(TodoRepository userRepository) {
        this.todoRepository = userRepository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return todoRepository.findAll();
    }

    @PostMapping
    public Todo createTodo(@RequestBody Todo todo) {
        return todoRepository.save(todo);
    }
}