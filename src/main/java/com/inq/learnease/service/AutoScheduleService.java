package com.inq.learnease.service;

import com.inq.learnease.dto.AutoScheduleRequestDto;
import com.inq.learnease.dto.task.TaskCreateRequestDto;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoScheduleService {
    public List<TaskCreateRequestDto> makeAutoSchedule(AutoScheduleRequestDto autoScheduleRequestDto) {
        List<TaskCreateRequestDto> response = new ArrayList<>();
        LocalDate start = autoScheduleRequestDto.startDate();
        LocalDate end = autoScheduleRequestDto.endDate();

        List<DayOfWeek> dayOfWeeks = new ArrayList<>();
        for (int i = 0; i < autoScheduleRequestDto.days().length; i++) {
             dayOfWeeks.add(DayOfWeek.of(autoScheduleRequestDto.days()[i]));
        }

        while (!start.equals(end)) {
            DayOfWeek dayOfWeek = start.getDayOfWeek();

            if (dayOfWeeks.contains(dayOfWeek)) {
                TaskCreateRequestDto dto = new TaskCreateRequestDto(
                        autoScheduleRequestDto.userId(),
                        autoScheduleRequestDto.license(),
                        start.toString(),
                        null,
                        autoScheduleRequestDto.Lecture()
                );

                response.add(dto);
            }
            start = start.plusDays(1);
        }
        return response;
    }
}
