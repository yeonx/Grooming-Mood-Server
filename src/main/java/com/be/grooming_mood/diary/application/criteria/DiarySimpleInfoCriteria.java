package com.be.grooming_mood.diary.application.criteria;

import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DiarySimpleInfoCriteria {
    private String userName;
    private String profileImg;
    private Long diaryId;
    private String diaryContent;

    @QueryProjection @Builder
    public DiarySimpleInfoCriteria(Long diaryId, String diaryContent, String userName, String profileImg){
        this.diaryId = diaryId;
        this.diaryContent = diaryContent;
        this.userName = userName;
        this.profileImg = profileImg;
    }
}
