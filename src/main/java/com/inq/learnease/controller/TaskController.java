package com.inq.learnease.controller;

import com.inq.learnease.dto.*;
import com.inq.learnease.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public long createTask(@AuthenticationPrincipal final LoginRequest loginRequest, @RequestBody TaskCreateRequestDto createRequestDto) {
        return taskService.create(loginRequest.getId(), createRequestDto);
    }

    @GetMapping("/all")
    public TaskReadResponseDto readAllTask(@AuthenticationPrincipal final LoginRequest loginRequest) {
        return taskService.readAll(loginRequest.getId());
    }

    @GetMapping("/category/{category}")
    public TaskReadResponseDto readByCategoryTask(@AuthenticationPrincipal final LoginRequest loginRequest, @PathVariable String category) {
        TaskReadByCategoryRequestDto readByCategoryRequestDto = new TaskReadByCategoryRequestDto(category);
        return taskService.readByCategory(loginRequest.getId(), readByCategoryRequestDto);
    }

    @GetMapping("/date/{date}")
    public TaskReadResponseDto readByDateTask(@AuthenticationPrincipal final LoginRequest loginRequest, @PathVariable String date) {
        TaskReadByDateRequestDto readByDateRequestDto = new TaskReadByDateRequestDto(date);
        return taskService.readByDate(loginRequest.getId(), readByDateRequestDto);
    }

    @PutMapping("/task")
    public long updateTask(@AuthenticationPrincipal final LoginRequest loginRequest, @RequestBody TaskUpdateRequestDto updateRequestDto) {
        return taskService.update(loginRequest.getId(), updateRequestDto);
    }

    @DeleteMapping("/task")
    public long deleteTask(@AuthenticationPrincipal final LoginRequest loginRequest, @RequestBody TaskDeleteRequestDto deleteRequestDto) {
        return taskService.delete(loginRequest.getId(), deleteRequestDto);
    }
}
