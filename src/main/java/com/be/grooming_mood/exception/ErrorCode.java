package com.be.grooming_mood.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    DIARY_NOT_FOUND(NOT_FOUND, "해당 다이어리를 찾을 수 없습니다."),
    USER_NOT_FOUND(NOT_FOUND, "해당 유저를 찾을 수 없습니다."),

    INVALID_EMAIL(BAD_REQUEST, "중복된 이메일입니다."),
    INVALID_PASSWORD(BAD_REQUEST, "잘못된 비밀번호입니다.");

    private final HttpStatus httpStatus;
    private final String detail;
}
