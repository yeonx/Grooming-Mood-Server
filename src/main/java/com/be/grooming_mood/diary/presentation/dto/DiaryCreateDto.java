package com.be.grooming_mood.diary.presentation.dto;

import com.be.grooming_mood.feeling.domain.FeelingType;
import com.sun.istack.NotNull;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class DiaryCreateDto {
    @NotNull
    private FeelingType feeling;

    @NotNull
    private String diaryContent;

    @NotNull
    private Boolean isPublic;

    @Builder
    public DiaryCreateDto(FeelingType feeling,
                          String diaryContent,
                          Boolean isPublic) {
        this.feeling = feeling;
        this.diaryContent = diaryContent;
        this.isPublic = isPublic;

    }
}
