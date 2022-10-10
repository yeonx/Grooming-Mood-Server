package com.be.grooming_mood.diary.domain;

import com.be.grooming_mood.common.domain.BaseTimeEntity;
import com.be.grooming_mood.feeling.domain.FeelingType;
import com.be.grooming_mood.user.domain.User;
import lombok.*;

import javax.persistence.*;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Entity
@Table(name = "diary")
public class Diary extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "feeling", nullable = false)
    @Enumerated(EnumType.STRING)
    private FeelingType feeling;

    @Column(name = "diary_content", nullable = false)
    private String diaryContent;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;

    @Builder
    public Diary(FeelingType feeling,
                 String diaryContent,
                 Boolean isPublic){
        this.feeling = feeling;
        this.diaryContent = diaryContent;
        this.isPublic = isPublic;
    }
}
