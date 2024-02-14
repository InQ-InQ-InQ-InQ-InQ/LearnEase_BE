package com.inq.learnease.controller;

import com.inq.learnease.dto.AutoScheduleRequestDto;
import com.inq.learnease.dto.LoginRequest;
import com.inq.learnease.entity.task.Task;
import com.inq.learnease.service.AutoScheduleFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class AutoScheduleController {
    private final AutoScheduleFacade scheduleFacade;

    @PostMapping("/autoSchedule")
    public ResponseEntity<List<Task>> makeAutoSchedule(LoginRequest loginRequest, AutoScheduleRequestDto autoScheduleRequestDto) {
        return ResponseEntity.ok(scheduleFacade.makeSchedule(loginRequest.getId(), autoScheduleRequestDto));
    }
}
