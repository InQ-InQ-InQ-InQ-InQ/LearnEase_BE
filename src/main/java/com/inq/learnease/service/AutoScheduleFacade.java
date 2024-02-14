package com.inq.learnease.service;

import com.inq.learnease.dto.AutoScheduleRequestDto;
import com.inq.learnease.dto.task.TaskCreateRequestDto;
import com.inq.learnease.entity.task.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AutoScheduleFacade {
    private final AutoScheduleService autoService;
    private final TaskService taskService;

    public List<Task> makeSchedule(long userId, AutoScheduleRequestDto dto) {
        List<TaskCreateRequestDto> taskDtos = autoService.makeAutoSchedule(dto);
        return taskService.create(userId, taskDtos);
    }
}
