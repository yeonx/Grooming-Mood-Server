package com.be.grooming_mood.user.controller;


import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.PostLoginRes;
import com.be.grooming_mood.user.dto.UserCreateDto;
import com.be.grooming_mood.user.dto.UserLoginDto;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @ApiOperation(value ="회원가입")
    @PostMapping("/signup")
    public Long signUp(@Valid UserCreateDto userCreateDto) {
        return userService.signUpUser(userCreateDto);
    }

    @ApiOperation(value ="로그인")
    @PostMapping("/login")
    public PostLoginRes login(@Valid @RequestBody UserLoginDto userLoginDto) {
        PostLoginRes loginUser = userService.loginUser(userLoginDto);
        return loginUser;
    }

    @ApiOperation(value ="유저 정보 조회")
    @GetMapping("/{userId}/info")
    public User getUserInfo(@PathVariable Long userId) {

        return userService.getUserInfo(userId);
    }

    @ApiOperation(value ="유저 정보 수정")
    @PostMapping("/{userId}/info")
    public void updateUserInfo(@PathVariable Long userId, @Valid @RequestBody UserUpdateDto userUpdateDto) {

       userService.updateUser(userId, userUpdateDto);
    }
}
