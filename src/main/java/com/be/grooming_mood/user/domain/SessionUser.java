package com.be.grooming_mood.user.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@Getter
public class SessionUser implements Serializable {
    private String nickname;
    private String email;
    private String profileImg;

    @Builder
    public SessionUser(User user) {
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.profileImg = user.getProfileImg();
    }
}
