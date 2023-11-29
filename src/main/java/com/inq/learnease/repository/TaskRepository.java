package com.inq.learnease.repository;

import com.inq.learnease.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {
    List<Task> findAllByUserId(long userId);
    List<Task> findAllByUserIdAndCategory(long userId, String category);
    List<Task> findAllByUserIdAndDate(long userId, String date);
}
