package com.be.grooming_mood.user.controller;


import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.PostLoginRes;
import com.be.grooming_mood.user.dto.UserCreateDto;
import com.be.grooming_mood.user.dto.UserLoginDto;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
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


//    @PostMapping("/login")
//    public PostLoginRes login(@Valid UserLoginDto userLoginDto) {
//        PostLoginRes loginUser = userService.login(userLoginDto);
//        return loginUser;
//    }

//    @GetMapping("/user-info")
//    public User getUserInfo() {
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        return userService.getUserInfo(user.getId());
//    }

//    @PostMapping("/user-info")
//    public void updateUserInfo(@Valid UserUpdateDto userUpdateDto) {
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//
//        System.out.println("user : " + user);
//        userService.updateUser(user.getId(), userUpdateDto);
//    }
}
