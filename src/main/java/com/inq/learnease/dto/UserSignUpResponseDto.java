package com.inq.learnease.dto;

import com.inq.learnease.entity.users.User;
import lombok.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@ToString
public class UserSignUpResponseDto {
    
    private Long id;
    
    public static UserSignUpResponseDto from(final User user) {
        return new UserSignUpResponseDto(user.getId());
    }
}
