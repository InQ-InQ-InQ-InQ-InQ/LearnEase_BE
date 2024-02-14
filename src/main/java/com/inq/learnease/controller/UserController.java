package com.inq.learnease.controller;

import com.inq.learnease.dto.*;
import com.inq.learnease.service.UserService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@Slf4j
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Long>> login(@RequestBody UserLoginDto loginRequest) {
        boolean authenticationResult = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (authenticationResult) {
            Map<String, Long> map = new HashMap<>();
            map.put("USER", userService.getUserId(loginRequest.getEmail()));
            return ResponseEntity.ok().body(map);
        } else {
            log.info("로그인 실패");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @PostMapping("/join")
    public ResponseEntity<UserSignUpResponseDto> join(@RequestBody @Valid final UserRequest userRequest) {
        UserSignUpResponseDto userSignUpResponseDto = userService.save(userRequest.toServiceDto());
        return ResponseEntity.ok(userSignUpResponseDto);
    }

    @PutMapping("/api/user")
    public ResponseEntity<Void> updateUser(@RequestBody @Valid final UserUpdateRequest userUpdateRequest) {
        userService.updateUser(userUpdateRequest.getNickname(), userUpdateRequest.getUserId());
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/api/user/{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }
}
