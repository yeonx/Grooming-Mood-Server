package com.be.grooming_mood.user.controller;

import com.be.grooming_mood.user.domain.SessionUser;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class UserController {
    private final HttpSession httpSession;
    private final UserService userService;




    @GetMapping("/user-info")
    public User getUserInfo() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        return userService.getUserInfo(user.getId());
    }

    @PostMapping("/user-info")
    public void updateUserInfo(@Valid UserUpdateDto userUpdateDto) {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        System.out.println("user : " + user);
        userService.updateUser(user.getId(), userUpdateDto);
    }
}
