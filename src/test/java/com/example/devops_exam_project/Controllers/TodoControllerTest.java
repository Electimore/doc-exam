package com.example.devops_exam_project.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.ArgumentMatcher;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.example.devops_exam_project.Entities.Todo;
import com.example.devops_exam_project.Repositories.TodoRepository;

@ExtendWith(MockitoExtension.class)
public class TodoControllerTest {
    @Mock
    private TodoRepository todoRepository;

    @InjectMocks
    private TodoController todoController;

    List<Todo> sampleTodos = new ArrayList<>();

    @BeforeEach
    public void setup() {
        sampleTodos = new ArrayList<>();
        sampleTodos.add(new Todo(1L, "Buy milk", false, new Date()));
        sampleTodos.add(new Todo(2L, "Clean room", true, new Date()));
    }

    @Test
    public void testGetAllTodos() {
        when(todoRepository.findAll()).thenReturn(sampleTodos);

        List<Todo> result = todoController.getAllTodos();

        assertEquals(2, result.size());
        verify(todoRepository).findAll();
    }

    @Test
    public void testSaveTodo() {
        Todo inputTodo = new Todo(null, "Do homework", false, null);
        Todo returnedTodo = new Todo(3L, "Do homework", false, new Date());

        when(todoRepository.save(any(Todo.class))).thenReturn(returnedTodo);

        todoController.createTodo(inputTodo);
        ArgumentCaptor<Todo> captor = ArgumentCaptor.forClass(Todo.class);
        verify(todoRepository).save(captor.capture());
        sampleTodos.add(captor.getValue());

        assertEquals(3, sampleTodos.size());
        assertEquals("Do homework", captor.getValue().getDescription());
        assertFalse(captor.getValue().isDone());
    }
}
