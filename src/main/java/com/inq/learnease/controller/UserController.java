package com.inq.learnease.controller;

import com.inq.learnease.controller.auth.AuthenticationPrincipal;
import com.inq.learnease.dto.*;
import com.inq.learnease.service.UserService;
import com.inq.learnease.support.JwtTokenProvider;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    private final JwtTokenProvider jwtTokenProvider;
    
    public UserController(UserService userService, JwtTokenProvider jwtTokenProvider) {
        this.userService = userService;
        this.jwtTokenProvider = jwtTokenProvider;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody UserLoginDto loginRequest) {
        boolean authenticationResult = userService.authenticateUser(loginRequest.getEmail(), loginRequest.getPassword());

        if (authenticationResult) {
            Map<String, Object> tokenPayload = JwtTokenProvider.payloadBuilder()
                    .setSubject(loginRequest.getEmail())
                    .put("USER")
                    .build();
            String token = jwtTokenProvider.createToken(tokenPayload);

            Map<String, String> response = new HashMap<>();
            response.put("token", token);

            return ResponseEntity.ok(response);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }
    
    @PostMapping("/user")
    public ResponseEntity<UserSignUpResponseDto> join(@RequestBody @Valid final UserRequest userRequest) {
        UserSignUpResponseDto userSignUpResponseDto = userService.save(userRequest.toServiceDto());
        return ResponseEntity
                .created(URI.create("/api/user/" + userSignUpResponseDto.getId()))
                .body(userSignUpResponseDto);
    }
    
    @PutMapping("/user")
    public ResponseEntity<Void> updateUser(
            @AuthenticationPrincipal final LoginRequest loginRequest,
            @RequestBody @Valid final UserUpdateRequest userUpdateRequest
    ) {
        userService.updateUser(userUpdateRequest.getNickname(), loginRequest.getId());
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/user")
    public ResponseEntity<Void> deleteUser(
            @AuthenticationPrincipal final LoginRequest loginRequest
    ) {
        userService.deleteUser(loginRequest.getId());
        return ResponseEntity.noContent().build();
    }
}
