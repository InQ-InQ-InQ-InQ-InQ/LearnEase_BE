package com.inq.learnease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String date;
    private String time;
    private String category;

    @Builder
    public Task(String name, String date, String time, String category) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.category = category;
    }
}
