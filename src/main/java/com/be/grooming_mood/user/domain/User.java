package com.be.grooming_mood.user.domain;

import com.be.grooming_mood.common.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
@Table(name="user")
public class User extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @Column(name="profileImg", columnDefinition = "TEXT")
    private String profileImg;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @Builder
    public User(String email, String nickname, String profileImg) {
        this.email = email;
        this.nickname = nickname;
        this.profileImg = profileImg;
    }

    public User update(String nickname, String profileImg) {
        this.nickname = nickname;
        this.profileImg = profileImg;

        return this;
    }

    public String getRoleKey(){
        return this.role.getKey();
    }
}
