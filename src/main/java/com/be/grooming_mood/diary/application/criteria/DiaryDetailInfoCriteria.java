package com.be.grooming_mood.diary.application.criteria;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.feeling.domain.FeelingType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryDetailInfoCriteria {
    private Long diaryId;
    private String diaryContent;
    private FeelingType feeling;

    @QueryProjection
    public DiaryDetailInfoCriteria(Diary diary){
        this.diaryId = diary.getId();
        this.diaryContent = diary.getDiaryContent();
        this.feeling = diary.getFeeling();
    }

    @Builder
    public DiaryDetailInfoCriteria(Long diaryId,
                                   String diaryContent,
                                   FeelingType feeling){
        this.diaryId = diaryId;
        this.diaryContent = diaryContent;
        this.feeling = feeling;
    }

}
