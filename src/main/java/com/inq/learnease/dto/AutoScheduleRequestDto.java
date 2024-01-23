package com.inq.learnease.dto;

public record AutoScheduleRequestDto(
        String startDate,
        String endDate,
        int[] days,
        String license,
        String Lecture) {
}
