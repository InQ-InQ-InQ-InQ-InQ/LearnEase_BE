package com.inq.learnease.dto;

import com.inq.learnease.entity.Task;
import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskCreateRequestDto {
    private final String name;
    private final String date;
    private final String time;
    private final String category;

    @Builder
    public TaskCreateRequestDto(String name, String date, String time, String category) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.category = category;
    }

    public Task toEntity() {
        return Task.builder()
                .name(name)
                .date(date)
                .time(time)
                .category(category)
                .build();
    }
}
