package com.inq.learnease.service;

import com.inq.learnease.dto.TaskCreateRequestDto;
import com.inq.learnease.dto.TaskReadByCategoryRequestDto;
import com.inq.learnease.dto.TaskReadByDateRequestDto;
import com.inq.learnease.dto.TaskReadResponseDto;
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
}
