package com.be.grooming_mood.user.dto;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class PostLoginRes {

    private String jwt;

    private Long id;

    @Builder
    public PostLoginRes(String jwt,
                        Long id) {
        this.jwt = jwt;
        this.id = id;

    }
}
