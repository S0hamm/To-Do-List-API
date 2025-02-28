package com.example.todo_api.service;
import com.example.todo_api.model.TodoItem;
import com.example.todo_api.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<TodoItem> getAllTodos() {
        return todoRepository.findAll();
    }

    public Optional<TodoItem> getTodoById(Long id) {
        return todoRepository.findById(id);
    }

    public TodoItem addTodo(TodoItem todoItem) {
        return todoRepository.save(todoItem);
    }
    public TodoItem updateTodo(Long id, TodoItem todoItem) {
        return todoRepository.findById(id)
                .map(existingTodo -> {
                    existingTodo.setTitle(todoItem.getTitle());
                    existingTodo.setDescription(todoItem.getDescription());
                    existingTodo.setCompleted(todoItem.isCompleted());
                    return todoRepository.save(existingTodo);
                })
                .orElseGet(() -> {
                    todoItem.setId(id);
                    return todoRepository.save(todoItem);
                });
    }

    public void deleteTodoById(Long id) {
        todoRepository.deleteById(id);
    }


}