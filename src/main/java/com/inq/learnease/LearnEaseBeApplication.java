package com.inq.learnease;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class LearnEaseBeApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(LearnEaseBeApplication.class, args);
    }
    
}
