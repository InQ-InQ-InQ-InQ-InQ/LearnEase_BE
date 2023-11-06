package com.inq.learnease.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserUpdateRequest {
    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    private String nickname;
}
