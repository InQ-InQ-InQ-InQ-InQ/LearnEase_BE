package com.inq.learnease.dto;

import com.inq.learnease.entity.users.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserRequest {
    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    private String loginId;
    
    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&.])[A-Za-z[0-9]$@$!%*#?&.]{" + 2 + "," + 16 + "}$",
            message = "비어있는 항목을 입력해주세요.")
    private String password;
    
    @NotBlank(message = "비어있는 항목을 입력해주세요.")
    private String nickname;
    
    public UserRequestDto toServiceDto() {
        return new UserRequestDto(
                Email.from(loginId),
                password,
                nickname
        );
    }
}
