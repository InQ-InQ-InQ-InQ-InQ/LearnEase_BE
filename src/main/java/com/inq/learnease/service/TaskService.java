package com.inq.learnease.service;

import com.inq.learnease.dto.*;
import com.inq.learnease.entity.Task;
import com.inq.learnease.repository.Repository;
import com.inq.learnease.vo.ResponseStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private final Repository repository;

    TaskService(Repository repository) {
        this.repository = repository;
    }
    public long create(TaskCreateRequestDto createRequestDto) {
        Task task = createRequestDto.toEntity();
        repository.save(task);
        return ResponseStatusCode.SUCCESS.value;
    }

    public TaskReadResponseDto readAll() {
        return new TaskReadResponseDto(repository.findAll());
    }

    public TaskReadResponseDto readByCategory(TaskReadByCategoryRequestDto readByCategoryRequestDto) {
        String category = readByCategoryRequestDto.getCategory();

        return new TaskReadResponseDto(repository.findAllByCategory(category));
    }

    public TaskReadResponseDto readByDate(TaskReadByDateRequestDto readByDateRequestDto) {
        String date = readByDateRequestDto.getDate();

        return new TaskReadResponseDto(repository.findAllByDate(date));
    }

    public long update(TaskUpdateRequestDto updateRequestDto) {
        Optional<Task> before = repository.findById(updateRequestDto.getTaskId());

        if (before.isEmpty()) {
            throw new IllegalArgumentException("there is no task correct id for update");
        }
        repository.delete(before.get());
        Task after = updateRequestDto.getTask();
        repository.save(after);

        return ResponseStatusCode.SUCCESS.value;
    }

    public long delete(TaskDeleteRequestDto deleteRequestDto) {
        Optional<Task> target = repository.findById(deleteRequestDto.getTaskId());

        if (target.isEmpty()) {
            throw new IllegalArgumentException("there is no task correct id for delete");
        }

        repository.delete(target.get());
        return ResponseStatusCode.SUCCESS.value;
    }
}
