package com.inq.learnease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goal {
    @Id
    private long id;
    @NotNull
    private String name;
    private LocalDate start;
    private LocalDate end;
}
