package com.inq.learnease.dto.task;

import com.inq.learnease.entity.task.Task;
import lombok.Builder;

public record TaskCreateRequestDto(String name, String date, String time, String category) {
    @Builder
    public Task toEntity(long userId) {
        return Task.builder()
                .userId(userId)
                .name(name)
                .date(date)
                .time(time)
                .category(category)
                .build();
    }
}
