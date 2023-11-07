package com.inq.learnease;

import com.inq.learnease.dto.TaskCreateRequestDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TaskCRUDTest {

    @DisplayName("Task_생성_테스트")
    @Test
    public void  Task_생성_테스트() {
        TaskCreateRequestDto testDto = TaskCreateRequestDto.builder()
                .name("test")
                .date("test")
                .time("test")
                .category("test")
                .build();
    }
}
