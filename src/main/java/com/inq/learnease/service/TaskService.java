package com.inq.learnease.service;

import com.inq.learnease.dto.task.*;
import com.inq.learnease.entity.task.Task;
import com.inq.learnease.repository.TaskRepository;
import com.inq.learnease.vo.ResponseStatusCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;

    public long create(long userId, TaskCreateRequestDto createRequestDto) {
        Task task = createRequestDto.toEntity(userId);
        taskRepository.save(task);
        return ResponseStatusCode.SUCCESS.value;
    }

    public List<Task> create(long userId, List<TaskCreateRequestDto> list) {
        List<Task> tasks = new ArrayList<>();
        for (TaskCreateRequestDto taskCreateRequestDto : list) {
            Task task = taskCreateRequestDto.toEntity(userId);
            tasks.add(task);
            taskRepository.save(task);
        }
        return tasks;
    }

    public TaskReadResponseDto readAll(long userId) {
        return new TaskReadResponseDto(taskRepository.findAllByUserId(userId));
    }

    public TaskReadResponseDto readByCategory(long userId, TaskReadByCategoryRequestDto readByCategoryRequestDto) {
        String category = readByCategoryRequestDto.category();

        return new TaskReadResponseDto(taskRepository.findAllByUserIdAndCategory(userId, category));
    }

    public TaskReadResponseDto readByDate(long userId, TaskReadByDateRequestDto readByDateRequestDto) {
        String date = readByDateRequestDto.date();

        return new TaskReadResponseDto(taskRepository.findAllByUserIdAndDate(userId, date));
    }

    public long update(long userId, TaskUpdateRequestDto updateRequestDto) {
        Optional<Task> before = taskRepository.findById(updateRequestDto.taskId());

        if (before.isEmpty()) {
            throw new IllegalArgumentException("there is no task correct id for update");
        }

        Task target = before.get();

        if (target.getUserId() != userId) {
            throw new IllegalArgumentException("only can update your own task");
        }

        taskRepository.delete(target);
        Task after = Task.builder()
                .name(updateRequestDto.name())
                .time(updateRequestDto.time())
                .category(updateRequestDto.category())
                .date(updateRequestDto.date())
                .userId(userId)
                .build();
        taskRepository.save(after);

        return ResponseStatusCode.SUCCESS.value;
    }

    public long delete(long userId, TaskDeleteRequestDto deleteRequestDto) {
        Optional<Task> target = taskRepository.findById(deleteRequestDto.taskId());

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
