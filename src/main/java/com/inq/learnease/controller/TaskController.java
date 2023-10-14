package com.inq.learnease.controller;

import com.inq.learnease.dto.TaskCreateRequestDto;
import com.inq.learnease.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {
    private final TaskService taskService;

    @Autowired
    TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public long createTask(@RequestBody TaskCreateRequestDto taskCreateRequestDto) {
        return taskService.create(taskCreateRequestDto);
    }
}
