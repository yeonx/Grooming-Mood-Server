package com.be.grooming_mood.user.dto;

import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class PostLoginRes {

    private String jwt;

    private String id;

    @Builder
    public PostLoginRes postLoginRes(String jwt,
                                     String id) {
        this.jwt = jwt;
        this.id = id;

        return this;
    }
}
