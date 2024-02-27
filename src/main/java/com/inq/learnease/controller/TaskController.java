package com.inq.learnease.controller;

import com.inq.learnease.dto.task.*;
import com.inq.learnease.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class TaskController {
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public long createTask(@RequestBody TaskCreateRequestDto createRequestDto) {
        return taskService.create(createRequestDto.userId(), createRequestDto);
    }

    @GetMapping("/task/all/{userId}")
    public TaskReadResponseDto readAllTask(@PathVariable long userId) {
        return taskService.readAll(userId);
    }

    @GetMapping("/task/category/{userId}/{category}")
    public TaskReadResponseDto readByCategoryTask(@PathVariable long userId, @PathVariable String category) {
        TaskReadByCategoryRequestDto readByCategoryRequestDto = new TaskReadByCategoryRequestDto(userId, category);
        return taskService.readByCategory(readByCategoryRequestDto.userId(), readByCategoryRequestDto);
    }

    @GetMapping("/task/date/{userId}/{date}")
    public TaskReadResponseDto readByDateTask(@PathVariable long userId, @PathVariable String date) {
        TaskReadByDateRequestDto readByDateRequestDto = new TaskReadByDateRequestDto(userId, date);
        return taskService.readByDate(readByDateRequestDto.userId(), readByDateRequestDto);
    }

    @PatchMapping("/task")
    public long updateTask(@RequestBody TaskUpdateRequestDto updateRequestDto) {
        return taskService.update(updateRequestDto.userId(), updateRequestDto);
    }

    @DeleteMapping("/task")
    public long deleteTask(@RequestBody TaskDeleteRequestDto deleteRequestDto) {
        return taskService.delete(deleteRequestDto.userId(), deleteRequestDto);
    }
}
