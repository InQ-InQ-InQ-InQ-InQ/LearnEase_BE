package com.inq.learnease.config;

import com.inq.learnease.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class DummyConfig {
    @Bean
    @Profile("local")
    public TestDataInit testDataInit(UserRepository userRepository) {
        return new TestDataInit(userRepository);
    }
}
