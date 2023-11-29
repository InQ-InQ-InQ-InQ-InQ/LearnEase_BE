package com.inq.learnease.controller.auth;

import com.inq.learnease.dto.MailCheckRequest;
import com.inq.learnease.dto.MailRequest;
import com.inq.learnease.dto.MailResponseDto;
import com.inq.learnease.service.MailService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @PostMapping("/api/signup/mailConfirm")
    public ResponseEntity<MailResponseDto> mailConfirm(@RequestBody @Valid final MailRequest mailRequest) throws Exception { // 받는 사람 이메일이 form 데이터로 들어와야 함
        MailResponseDto mailResponseDto = mailService.sendSimpleMessage(mailRequest.getEmail());
        return ResponseEntity
                .created(URI.create("/api/login/mailConfirm" + mailResponseDto.getId()))
                .body(mailResponseDto);
    }

    @PostMapping("/api/signup/checkNumber")
    public ResponseEntity<Void> checkNumber(@RequestBody @Valid MailCheckRequest mailCheckReqeust) {
        mailService.validateNumber(mailCheckReqeust.getId(), mailCheckReqeust.getNumber());
        return ResponseEntity.noContent().build();
    }
}
