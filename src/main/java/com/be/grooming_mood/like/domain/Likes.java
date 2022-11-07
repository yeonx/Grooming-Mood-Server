package com.be.grooming_mood.like.domain;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.user.domain.User;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "likes")
public class Likes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "diary_id", nullable = false)
    private Diary diary;

    @Builder
    public Likes(User user, Diary diary){
        this.diary = diary;
        this.user = user;
    }

    @Transient
    private long likesCount;

    public void updateLikesCount(long likesCount) {
        this.likesCount = likesCount;
    }
}
