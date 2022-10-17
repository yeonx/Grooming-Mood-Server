package com.be.grooming_mood.user.controller;

import com.be.grooming_mood.config.auth.LoginUser;
import com.be.grooming_mood.exception.ErrorCode;
import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.user.domain.SessionUser;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.dto.UserUpdateDto;
import com.be.grooming_mood.user.service.UserService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "내 정보 보기")
    @GetMapping("/user-info")

    public User getUserInfo() {
        SessionUser user = (SessionUser) httpSession.getAttribute("user");

        return userService.getUserInfo(user.getId());
    }

    @ApiOperation(value = "내 정보 수정")
    @PostMapping("/user-info")
    public void updateUserInfo(@LoginUser SessionUser user,
                               @Valid UserUpdateDto userUpdateDto) {
        userService.updateUser(user.getId(), userUpdateDto);
    }
}
