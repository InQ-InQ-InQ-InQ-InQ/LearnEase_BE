/*
package com.inq.learnease.entity.users;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserTest {
    @Test
    @DisplayName("회원의 닉네임을 수정한다.")
    void changeNickname() {
        // given
        User dummyUser = new User(
                Email.from("1@naver.com"),
                "dummyPassword",
                "learnEaseBe"
        );
        String expectedNickname = "changeNick";
    
        // when
        dummyUser.changeNickname(expectedNickname);
      
        // then
        assertThat(dummyUser.getNickname()).isEqualTo(expectedNickname);
    }
    
    @Test
    @DisplayName("회원을 생성한다.")
    void construct() {
        assertDoesNotThrow(() -> new User(
                Email.from("1@naver.com"),
                "dummyPassword",
                "learnEaseBe"
        ));
    }
}*/
