package com.inq.learnease.config;

import com.inq.learnease.entity.users.Email;
import com.inq.learnease.entity.users.User;
import com.inq.learnease.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@RequiredArgsConstructor
public class TestDataInit {
    private final UserRepository userRepository;
    
    @EventListener(ApplicationReadyEvent.class)
    public void initData() {
        User user = new User(
                Email.from("1@naver.com"),
                "dummyPassword",
                "learnEaseBe"
        );
        userRepository.save(user);
    }
}
