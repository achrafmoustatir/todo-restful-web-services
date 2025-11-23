package com.achraf.rest.webservice.todo_restful_web_services.service;
import com.achraf.rest.webservice.todo_restful_web_services.model.Todo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class TodoService {

    private static final List<Todo> todos = new ArrayList<>();
    private static final AtomicLong counter = new AtomicLong();

    static {
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Learn Angular", "Start from basics and build up", false, LocalDate.of(2025, 5, 1)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Write Documentation", "Document all components clearly", true, LocalDate.of(2025, 4, 28)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Fix login bug", "Resolve issue with login form validation", false, LocalDate.of(2025, 5, 2)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Refactor Todo Service", "Clean up code in todo.service.ts", true, LocalDate.of(2025, 4, 25)));
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Add unit tests", "Write tests for ListTodosComponent", false, LocalDate.of(2025, 5, 10)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Deploy to Firebase", "Set up CI/CD and deploy app", false, LocalDate.of(2025, 5, 15)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Create 404 page", "Add custom error page for unknown routes", true, LocalDate.of(2025, 4, 20)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Improve styling", "Make UI more responsive and clean", false, LocalDate.of(2025, 5, 5)));
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Optimize performance", "Reduce load time and improve efficiency", false, LocalDate.of(2025, 5, 12)));
        todos.add(new Todo(counter.incrementAndGet(), "user", "Add user authentication", "Implement login and registration features", false, LocalDate.of(2025, 5, 20)));
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Integrate with backend", "Connect frontend with backend API", false, LocalDate.of(2025, 5, 25)));
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Conduct user testing", "Gather feedback from users and improve app", false, LocalDate.of(2025, 5, 30)));
        todos.add(new Todo(counter.incrementAndGet(), "admin", "Set up analytics", "Track user behavior and app performance", false, LocalDate.of(2025, 6, 1)));
    }

    public List<Todo> findAllTodos(String username) {
        return todos.stream()
                .filter(todo -> todo.getUsername().equalsIgnoreCase(username))
                .sorted(Comparator.comparing(Todo::getId))
                .toList();
    }

    public Optional<Todo> findTodoByIdUsername(Long id, String username) {

        return todos.stream()
                .filter(todo -> todo.getId().equals(id) && todo.getUsername().equalsIgnoreCase(username))
                .findFirst();
    }

    public boolean deleteByIdUsername(Long id,String  username) {
        return todos.removeIf(t ->
                t.getId().equals(id) && t.getUsername().equalsIgnoreCase(username));
    }

    public Todo save(Todo todo){
        if (todo.getId() == null){
            todo.setId(counter.incrementAndGet());
            todos.add(todo);
        }
        else {
            deleteByIdUsername(todo.getId(),todo.getUsername());
           todos.add(todo);
        }


        return todo;
    }


}
