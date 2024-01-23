package com.inq.learnease.dto.task;

public record TaskUpdateRequestDto(String name, String date, String time, String category, long taskId) {
}
