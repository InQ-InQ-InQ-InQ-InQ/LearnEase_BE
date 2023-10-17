package com.inq.learnease.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskDeleteRequestDto {
    private final long taskId;

    @Builder
    TaskDeleteRequestDto(long id) {
        this.taskId = id;
    }
}
