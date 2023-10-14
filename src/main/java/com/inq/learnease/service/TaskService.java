package com.inq.learnease.service;

import com.inq.learnease.dto.TaskCreateRequestDto;
import com.inq.learnease.entity.Task;
import com.inq.learnease.repository.Repository;
import com.inq.learnease.vo.ResponseStatusCode;
import org.springframework.stereotype.Service;

@Service
public class TaskService {
    private final Repository repository;

    TaskService(Repository repository) {
        this.repository = repository;
    }
    public long create(TaskCreateRequestDto taskCreateRequestDto) {
        Task task = taskCreateRequestDto.toEntity();
        repository.save(task);
        return ResponseStatusCode.SUCCESS.value;
    }
}
