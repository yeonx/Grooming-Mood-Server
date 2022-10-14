package com.be.grooming_mood.user.controller;

import com.be.grooming_mood.config.auth.LoginUser;
import com.be.grooming_mood.user.domain.SessionUser;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {

    private final UserService userService;

    @GetMapping("/user-info")
    public User getUserInfo(@LoginUser SessionUser user) {
        return userService.getUserInfo(user.getId());
    }

    @PostMapping("/user-info")
    public void updateUserInfo(@LoginUser SessionUser user,
                               @Valid UserUpdateDto userUpdateDto) {
        userService.updateUser(user.getId(), userUpdateDto);
    }
}
