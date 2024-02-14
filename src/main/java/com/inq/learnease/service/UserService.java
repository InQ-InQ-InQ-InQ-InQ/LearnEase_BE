package com.inq.learnease.service;

import com.inq.learnease.dto.UserRequestDto;
import com.inq.learnease.dto.UserSignUpResponseDto;
import com.inq.learnease.entity.users.Email;
import com.inq.learnease.entity.users.User;
import com.inq.learnease.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    
    public UserSignUpResponseDto save(final UserRequestDto userRequestDto) {
        validateLoginIdHasDuplicate(userRequestDto.getLoginId());
        String password = userRequestDto.getPassword();
    
        User user = new User(userRequestDto.getLoginId(), password, userRequestDto.getNickname());
        User saveUser = userRepository.save(user);
        return UserSignUpResponseDto.from(saveUser);
    }
    
    public void updateUser(final String nickname, final Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException());
        
        user.changeNickname(nickname);
    }
    
    public void validateLoginIdHasDuplicate(final Email loginId) {
        if (userRepository.existsByLoginId(loginId)) {
            throw new IllegalArgumentException();
        }
    }
    
    public void deleteUser(final Long userId) {
        userRepository.findById(userId)
                .orElseThrow(() -> new IllegalArgumentException());
        
        userRepository.deleteById(userId);
    }

    public boolean authenticateUser(String username, String password) {
        User user = userRepository.findByLoginId(Email.from(username))
                .orElseThrow(NoSuchElementException::new);
        return user.getPassword().equals(password);
    }

    public long getUserId(String username) {
        User user = userRepository.findByLoginId(Email.from(username))
                .orElseThrow(NoSuchElementException::new);
        return user.getId();
    }
}
