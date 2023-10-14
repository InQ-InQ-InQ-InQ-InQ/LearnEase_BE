package com.inq.learnease.repository;

import com.inq.learnease.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Task, Long> {
}
