package com.achraf.rest.webservice.todo_restful_web_services.model;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;


public class Todo {

    private Long id;
    private String username;

    @NotBlank(message = "Title is required")
    private String title;
    private String description;
    private boolean status;
    private LocalDate targetDate;


    public Todo() {}

    public Todo(Long id, String username, String title, String description, boolean status, LocalDate targetDate) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.description = description;
        this.status = status;
        this.targetDate = targetDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public LocalDate getTargetDate() {
        return targetDate;
    }

    public void setTargetDate(LocalDate targetDate) {
        this.targetDate = targetDate;
    }
}
