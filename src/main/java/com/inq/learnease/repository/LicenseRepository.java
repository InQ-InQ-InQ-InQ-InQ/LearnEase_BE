package com.inq.learnease.repository;

import com.inq.learnease.entity.License;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LicenseRepository extends JpaRepository<License, Long> {
    Optional<License> findByName(String licenseName);
}
