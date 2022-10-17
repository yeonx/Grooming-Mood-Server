package com.be.grooming_mood.user.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Builder
public class UserSignUpResponseDto {

    private String email;
    private String password;
    private String name;


}
