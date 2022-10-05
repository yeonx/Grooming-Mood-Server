package com.be.grooming_mood.diary.domain;

import com.be.grooming_mood.common.domain.BaseTimeEntity;
import com.be.grooming_mood.feeling.domain.FeelingType;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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

    @Column(name = "feeling", nullable = false)
    @Enumerated(EnumType.STRING)
    private FeelingType feeling;

    @Column(name = "diary_content", nullable = false)
    private String diaryContent;

    @Column(name = "is_public", nullable = false)
    private Boolean isPublic;
}
