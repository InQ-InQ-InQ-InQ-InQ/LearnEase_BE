package com.inq.learnease.controller;

import com.inq.learnease.dto.TaskCreateRequestDto;
import com.inq.learnease.dto.TaskReadByCategoryRequestDto;
import com.inq.learnease.dto.TaskReadByDateRequestDto;
import com.inq.learnease.dto.TaskReadResponseDto;
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
    public long createTask(@RequestBody TaskCreateRequestDto createRequestDto) {
        return taskService.create(createRequestDto);
    }

    @GetMapping("/all")
    public TaskReadResponseDto readAllTask() {
        return taskService.readAll();
    }

    @GetMapping("/{category}")
    public TaskReadResponseDto readByCategoryTask(@PathVariable String category) {
        TaskReadByCategoryRequestDto readByCategoryRequestDto = new TaskReadByCategoryRequestDto(category);
        return taskService.readByCategory(readByCategoryRequestDto);
    }

    @GetMapping("/{date}")
    public TaskReadResponseDto readByDateTask(@PathVariable String date) {
        TaskReadByDateRequestDto readByDateRequestDto = new TaskReadByDateRequestDto(date);
        return taskService.readByDate(readByDateRequestDto);
    }
}
