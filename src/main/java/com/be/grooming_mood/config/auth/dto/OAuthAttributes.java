package com.be.grooming_mood.config.auth.dto;

import com.be.grooming_mood.user.domain.User;
import lombok.Builder;
import lombok.Getter;

import java.util.Map;

@Getter
public class OAuthAttributes {
    private Map<String, Object> attributes;
    private String nameAttributeKey;
    private String nickname;
    private String email;
    private String profileImg;

    @Builder
    public OAuthAttributes(
            Map<String, Object> attributes,
            String nameAttributeKey,
            String nickname,
            String email,
            String profileImg) {

        this.attributes = attributes;
        this.nameAttributeKey = nameAttributeKey;
        this.nickname = nickname;
        this.email = email;
        this.profileImg = profileImg;

    }

    public static OAuthAttributes of(
            String registrationId,
            String userNameAttributeName,
            Map<String, Object> attributes) {
        return ofGoogle(userNameAttributeName, attributes);
    }

    public static OAuthAttributes ofGoogle(
            String userNameAttributeName,
            Map<String, Object> attributes) {
        return OAuthAttributes.builder()
                .nickname((String) attributes.get("nickname"))
                .email((String) attributes.get("email"))
                .profileImg((String) attributes.get("profileImg"))
                .attributes(attributes)
                .nameAttributeKey(userNameAttributeName)
                .build();
    }

    public User toEntity() {
        return User.builder()
                .nickname(nickname)
                .email(email)
                .profileImg(profileImg)
                .build();
    }

}
