package com.be.grooming_mood.user.controller;


import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.PostLoginRes;
import com.be.grooming_mood.user.dto.UserCreateDto;
import com.be.grooming_mood.user.dto.UserLoginDto;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public Long signUp(@Valid UserCreateDto userCreateDto) {
        return userService.signUpUser(userCreateDto);
    }


    @PostMapping("/login")
    public PostLoginRes login(@Valid @RequestBody UserLoginDto userLoginDto) {
        PostLoginRes loginUser = userService.loginUser(userLoginDto);
        return loginUser;
    }

    @GetMapping("/{userId}/info")
    public User getUserInfo(@PathVariable Long userId) {

        return userService.getUserInfo(userId);
    }

    @PostMapping("/{userId}/info")
    public void updateUserInfo(@PathVariable Long userId, @Valid @RequestBody UserUpdateDto userUpdateDto) {

       userService.updateUser(userId, userUpdateDto);
    }
}
