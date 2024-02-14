package com.inq.learnease.dto.task;

public record TaskUpdateRequestDto(long userId, String name, String date, String time, String category, long taskId) {
}
