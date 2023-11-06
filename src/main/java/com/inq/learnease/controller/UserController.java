package com.inq.learnease.controller;

import com.inq.learnease.dto.UserRequest;
import com.inq.learnease.dto.UserSignUpResponseDto;
import com.inq.learnease.dto.UserUpdateRequest;
import com.inq.learnease.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;
    
    public UserController(UserService userService) {
        this.userService = userService;
    }
    
    @PostMapping("/user")
    public ResponseEntity<UserSignUpResponseDto> join(@RequestBody @Valid final UserRequest userRequest) {
        UserSignUpResponseDto userSignUpResponseDto = userService.save(userRequest.toServiceDto());
        return ResponseEntity
                .created(URI.create("/api/students/" + userSignUpResponseDto.getId()))
                .body(userSignUpResponseDto);
    }
    
    @PutMapping("/user/{id}")
    public ResponseEntity<Void> updateUser(
            @PathVariable final Long id,
            @RequestBody @Valid final UserUpdateRequest userUpdateRequest
    ) {
        userService.updateUser(userUpdateRequest.getNickname(), id);
        return ResponseEntity.noContent().build();
    }
    
    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> deleteUser(
            @PathVariable final Long id
    ) {
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
