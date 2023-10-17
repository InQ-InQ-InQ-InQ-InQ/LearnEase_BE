package com.inq.learnease.repository;

import com.inq.learnease.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Task, Long> {
    List<Task> findAllByCategory(String category);
    List<Task> findAllByDate(String date);
}
