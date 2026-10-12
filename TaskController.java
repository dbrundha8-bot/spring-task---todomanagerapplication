package com.example.todomanager.controller;

import com.example.todomanager.model.Task;
import com.example.todomanager.service.TaskService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    @GetMapping("/{id}")
    public Task getTaskById(@PathVariable Long id) {
        return taskService.getTaskById(id);
    }

    @PostMapping
    public Task createTask(@RequestBody Task task) {
        return taskService.createTask(task);
    }

    @PutMapping("/{id}")
    public Task updateTask(
            @PathVariable Long id,
            @RequestBody Task task) {
        return taskService.updateTask(id, task);
    }

    @DeleteMapping("/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "Task deleted successfully";
    }

    @PatchMapping("/{id}/toggle")
    public Task toggleStatus(@PathVariable Long id) {
        return taskService.toggleStatus(id);
    }

    @GetMapping("/priority/{priority}")
    public List<Task> getTasksByPriority(
            @PathVariable String priority) {
        return taskService.getTasksByPriority(priority);
    }
}
