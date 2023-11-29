package com.inq.learnease.dto;

import com.inq.learnease.entity.Certification;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class MailResponseDto {
    private Long id;

    public static MailResponseDto from(final Certification certification) {
        return new MailResponseDto(certification.getId());
    }
}
