package com.inq.learnease.service;

import com.inq.learnease.dto.*;
import com.inq.learnease.entity.Task;
import com.inq.learnease.repository.TaskRepository;
import com.inq.learnease.vo.ResponseStatusCode;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public long create(long userId, TaskCreateRequestDto createRequestDto) {
        Task task = createRequestDto.toEntity(userId);
        taskRepository.save(task);
        return ResponseStatusCode.SUCCESS.value;
    }

    public TaskReadResponseDto readAll(long userId) {
        return new TaskReadResponseDto(taskRepository.findAllByUserId(userId));
    }

    public TaskReadResponseDto readByCategory(long userId, TaskReadByCategoryRequestDto readByCategoryRequestDto) {
        String category = readByCategoryRequestDto.getCategory();

        return new TaskReadResponseDto(taskRepository.findAllByUserIdAndCategory(userId, category));
    }

    public TaskReadResponseDto readByDate(long userId, TaskReadByDateRequestDto readByDateRequestDto) {
        String date = readByDateRequestDto.getDate();

        return new TaskReadResponseDto(taskRepository.findAllByUserIdAndDate(userId, date));
    }

    public long update(long userId, TaskUpdateRequestDto updateRequestDto) {
        Optional<Task> before = taskRepository.findById(updateRequestDto.getTaskId());

        if (before.isEmpty()) {
            throw new IllegalArgumentException("there is no task correct id for update");
        }

        Task target = before.get();

        if (target.getUserId() != userId) {
            throw new IllegalArgumentException("only can update your own task");
        }

        taskRepository.delete(target);
        Task after = updateRequestDto.getTask();
        taskRepository.save(after);

        return ResponseStatusCode.SUCCESS.value;
    }

    public long delete(long userId, TaskDeleteRequestDto deleteRequestDto) {
        Optional<Task> target = taskRepository.findById(deleteRequestDto.getTaskId());

        if (target.isEmpty()) {
            throw new IllegalArgumentException("there is no task correct id for delete");
        }

        Task existTarget = target.get();

        if (existTarget.getUserId() != userId) {
            throw new IllegalArgumentException("only can delete your own task");
        }

        taskRepository.delete(target.get());
        return ResponseStatusCode.SUCCESS.value;
    }
}
