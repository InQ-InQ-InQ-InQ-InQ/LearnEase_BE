package com.inq.learnease.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskReadByCategoryRequestDto {
    private final String category;

    @Builder
    public TaskReadByCategoryRequestDto(String category) {
        this.category = category;
    }
}
