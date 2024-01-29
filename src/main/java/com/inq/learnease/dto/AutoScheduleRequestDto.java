package com.inq.learnease.dto;

import java.time.LocalDate;

public record AutoScheduleRequestDto(
        LocalDate startDate,
        LocalDate endDate,
        int[] days,
        String license,
        String Lecture) {
}
