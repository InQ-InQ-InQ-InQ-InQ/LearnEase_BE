package com.inq.learnease.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class TaskReadByDateRequestDto {
    private final String date;

    @Builder
    public TaskReadByDateRequestDto(String date) {
        this.date = date;
    }
}
