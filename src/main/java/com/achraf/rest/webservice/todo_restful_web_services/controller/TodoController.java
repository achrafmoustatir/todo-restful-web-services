package com.achraf.rest.webservice.todo_restful_web_services.controller;

import com.achraf.rest.webservice.todo_restful_web_services.model.Todo;
import com.achraf.rest.webservice.todo_restful_web_services.service.TodoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users/{username}/todos")
public class TodoController {

    private final TodoService todoService;

    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }

    @GetMapping
    public List<Todo> getTodos(@PathVariable String username) {
        return todoService.findAllTodos(username);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Todo> getTodo(@PathVariable Long id, @PathVariable String username) {
        return todoService.findTodoByIdUsername(id,username)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable Long id, @PathVariable String username) {
        boolean deleted = todoService.deleteByIdUsername(id,username);
        return deleted ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable String username,@PathVariable Long id, @Valid @RequestBody Todo todo){
        todo.setUsername(username);
        todo.setId(id);
        Todo updated = todoService.save(todo);
        return ResponseEntity.ok(updated);
    }

    @PostMapping
    public ResponseEntity<Todo> createTodo(@PathVariable String username, @Valid @RequestBody Todo todo){
        todo.setUsername(username);
        Todo created = todoService.save(todo);
        return ResponseEntity.ok(created);
    }


}
