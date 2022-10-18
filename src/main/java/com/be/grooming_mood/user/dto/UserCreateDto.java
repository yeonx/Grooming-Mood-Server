package com.be.grooming_mood.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserCreateDto {

    private String email;
    private String password;
    private String name;

    @Builder
    public UserCreateDto(String email,
                         String password,
                         String name) {
        this.email = email;
        this.password = password;
        this.name = name;
    }

}
