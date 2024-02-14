package com.inq.learnease.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class UserLoginDto {
    private final String email;
    private final String password;
}
