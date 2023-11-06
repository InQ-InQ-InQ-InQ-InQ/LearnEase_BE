package com.inq.learnease.dto;

import com.inq.learnease.entity.users.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UserRequestDto {
    private Email loginId;
    
    private String password;
    
    private String nickname;
}
