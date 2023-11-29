package com.inq.learnease.dto;

public record TaskUpdateRequestDto(String name, String date, String time, String category, long taskId) {
}
