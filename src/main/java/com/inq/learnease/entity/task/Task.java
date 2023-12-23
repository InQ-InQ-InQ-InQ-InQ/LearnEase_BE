package com.inq.learnease.entity.task;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Getter
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long userId;

    @Column(name = "task_name", length = 255, nullable = false)
    private String name;

    private String date;
    private String time;
    private String category;

    @Builder
    public Task(long userId, String name, String date, String time, String category) {
        this.userId = userId;
        this.name = name;
        this.date = date;
        this.time = time;
        this.category = category;
    }
}
