package com.be.grooming_mood.user.service;

import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void updateUser(Long userId, UserUpdateDto userUpdateDto) {
        Optional<User> userCheck = userRepository.findById(userId);

        User user = userCheck.orElseThrow(() ->
                new RuntimeException("유저를 찾을 수 없습니다."));

        user.update(userUpdateDto.getName(), userUpdateDto.getProfileImg());
        userRepository.save(user);
    }

}
