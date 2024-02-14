package com.inq.learnease.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class License {
    @Id
    private long id;
    private String name;

    @Builder
    public License(String name) {
        License.builder()
                .name(name)
                .build();
    }
}
