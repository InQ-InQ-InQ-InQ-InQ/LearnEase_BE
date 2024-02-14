package com.inq.learnease.controller;

import com.inq.learnease.dto.license.LicenseDto;
import com.inq.learnease.service.LicenseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class LicenseController {
    private final LicenseService service;

    @PostMapping("/license")
    public ResponseEntity<LicenseDto> create(LicenseDto dto) {
        LicenseDto response = service.create(dto);
        return ResponseEntity.ok(response);
    }

    @GetMapping("licenses")
    public ResponseEntity<List<LicenseDto>> readAll() {
        List<LicenseDto> response = service.readAll();
        return ResponseEntity.ok(response);
    }
}
