package com.be.grooming_mood.oauth.jwt;

import lombok.Builder;
import lombok.Getter;

@Getter
public class JwtResponse {
    private String accessToken;

    public JwtResponse createJWT(String accessToken){
        this.accessToken = accessToken;

        return this;
    }
}
