package com.example.devops_exam_project.Controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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

    @Test
    public void testGetAllTodos() {
        List<Todo> sampleTodos = new ArrayList<>();
        sampleTodos.add(new Todo(1L, "Buy milk", false, new Date()));
        sampleTodos.add(new Todo(2L, "Clean room", true, new Date()));

        when(todoRepository.findAll()).thenReturn(sampleTodos);

        List<Todo> result = todoController.getAllTodos();

        assertEquals(2, result.size());
        verify(todoRepository).findAll();
    }
}
