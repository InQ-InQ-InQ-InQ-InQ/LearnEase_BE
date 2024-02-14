package com.inq.learnease.repository;

import com.inq.learnease.entity.users.Email;
import com.inq.learnease.entity.users.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLoginId(final Email loginId);
    Optional<User> findByLoginId(Email email);
}
