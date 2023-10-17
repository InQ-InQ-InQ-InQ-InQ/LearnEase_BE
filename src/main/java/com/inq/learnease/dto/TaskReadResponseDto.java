package com.inq.learnease.dto;

import com.inq.learnease.entity.Task;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class TaskReadResponseDto {
    private final List<Task> tasks;

    @Builder
    public TaskReadResponseDto(List<Task> tasks) {
        this.tasks = tasks;
    }
}
