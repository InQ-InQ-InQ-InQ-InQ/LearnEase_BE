package com.inq.learnease.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MailCheckRequest {
    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    private String id;

    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    private String number;
}
