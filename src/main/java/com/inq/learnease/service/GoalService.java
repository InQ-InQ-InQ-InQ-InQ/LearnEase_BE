package com.inq.learnease.service;

import com.inq.learnease.dto.AutoScheduleRequestDto;
import com.inq.learnease.entity.Goal;
import com.inq.learnease.entity.users.User;
import com.inq.learnease.repository.GoalRepository;
import com.inq.learnease.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Service
public class GoalService {
    private final GoalRepository repository;
    private final UserRepository userRepository;

    public void makeGoal(AutoScheduleRequestDto requestDto) {
        repository.save(Goal.builder()
                .name(requestDto.license())
                .start(requestDto.startDate())
                .end(requestDto.endDate())
                .build());
    }

    public List<Goal> readAll(long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("no user Entity"));

        return user.getGoals();
    }
}
