package com.inq.learnease.dto;

import com.inq.learnease.entity.Task;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskUpdateRequestDto {
    private final Task task;
    private final long taskId;

    @Builder
    TaskUpdateRequestDto(long taskId, String name, String date, String time, String category) {
        this.task = Task.builder()
                .name(name)
                .date(date)
                .time(time)
                .category(category)
                .build();

        this.taskId = taskId;
    }
}
