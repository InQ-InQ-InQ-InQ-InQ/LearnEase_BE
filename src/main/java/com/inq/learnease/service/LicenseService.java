package com.inq.learnease.service;

import com.inq.learnease.dto.license.LicenseDto;
import com.inq.learnease.entity.License;
import com.inq.learnease.repository.CertificationRepository;
import com.inq.learnease.repository.LicenseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class LicenseService {
    private final LicenseRepository repository;

    public LicenseDto create(LicenseDto dto) {
        License license = new License(dto.name());

        if (repository.findByLicenseName(dto.name()).isEmpty()) {
            repository.save(license);
            return dto;
        }
        throw new IllegalArgumentException("duplicated license");
    }

    public List<LicenseDto> readAll() {
        List<LicenseDto> response = new ArrayList<>();
        repository.findAll()
                .forEach(license -> response.add(new LicenseDto(license.getName())));

        return response;
    }
}
