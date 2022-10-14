package com.be.grooming_mood.reaction.domain;

import com.be.grooming_mood.common.domain.BaseTimeEntity;
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
@Table(name="reaction")
public class Reaction extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="diary_id", nullable = false)
    private Diary diary;

    @Enumerated(EnumType.STRING)
    @Column(name="reaction", nullable = false)
    private ReactionType reaction;

    @Builder
    public Reaction(User user,
                    Diary diary,
                    ReactionType reaction){
        this.user = user;
        this.diary = diary;
        this.reaction = reaction;

    }

    public void update(ReactionType reaction){
        this.reaction = reaction;
    }

}
