package com.be.grooming_mood.diary.application.criteria;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.feeling.domain.FeelingType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter
public class DiarySimpleInfoCriteria {
    private String userName;
    private String profileImg;
    private Long diaryId;
    private String diaryContent;
    private FeelingType feeling;
    private LocalDateTime createdDate;
    private Integer likesCount;


    @QueryProjection @Builder
    public DiarySimpleInfoCriteria(Diary diary, Long diaryId, String diaryContent, String userName,
                                   String profileImg, FeelingType feeling,
                                   LocalDateTime createdDate){
        this.diaryId = diaryId;
        if (diaryContent.length() > 27)
            this.diaryContent = diaryContent.substring(0,27);
        else
            this.diaryContent = diaryContent;
        this.userName = userName;
        this.profileImg = profileImg;
        this.feeling = feeling;
        this.createdDate = createdDate;
        this.likesCount = diary.getLikesCount();
    }
}
