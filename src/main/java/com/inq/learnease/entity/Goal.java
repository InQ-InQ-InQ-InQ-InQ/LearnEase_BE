package com.inq.learnease.entity;

import com.inq.learnease.entity.users.User;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Goal {
    @Id
    private long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @NotNull
    private String name;
    private LocalDate start;
    private LocalDate end;

    @Builder
    public Goal(String name, LocalDate start, LocalDate end) {
        this.name = name;
        this.start = start;
        this.end = end;
    }
}
