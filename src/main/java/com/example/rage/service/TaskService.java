package com.example.rage.service;

import com.example.rage.model.Task;

import java.util.List;

public interface TaskService {
    List<Task> getAllTasks();

    Task createTask(Task task);

    Task getTaskById(Long id);

    Task updateTask(Long id, Task task);

    void deleteTask(Long id);

    void addTask(Task task);
}
