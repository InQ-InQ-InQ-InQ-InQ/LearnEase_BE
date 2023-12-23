package com.inq.learnease.dto;

import com.inq.learnease.entity.task.Task;

import java.util.List;

public record TaskReadResponseDto(List<Task> tasks) {
}
