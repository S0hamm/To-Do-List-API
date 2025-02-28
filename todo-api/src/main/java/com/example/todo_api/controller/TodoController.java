package com.example.todo_api.controller;

import com.example.todo_api.model.TodoItem;
import com.example.todo_api.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/todos")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @GetMapping
    public List<TodoItem> getAllTodos() {
        return todoService.getAllTodos();
    }
    @GetMapping("/{id}")
    public ResponseEntity<TodoItem> getTodoById(@PathVariable Long id) {
        Optional<TodoItem> todoItem = todoService.getTodoById(id);
        return todoItem.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public TodoItem addTodo(@RequestBody TodoItem todoItem) {
        return todoService.addTodo(todoItem);
    }

    @PutMapping("/{id}")
    public ResponseEntity<TodoItem> updateTodo(@PathVariable Long id, @RequestBody TodoItem todoItem) {
        Optional<TodoItem> updatedTodo = Optional.ofNullable(todoService.updateTodo(id, todoItem));
        return updatedTodo.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        todoService.deleteTodoById(id);
        return ResponseEntity.noContent().build();
    }
}