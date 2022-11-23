package com.be.grooming_mood.diary.application.criteria;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.feeling.domain.FeelingType;
import com.be.grooming_mood.user.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

import static com.be.grooming_mood.diary.domain.QDiary.diary;

@Getter
public class DiaryDetailInfoCriteria {
    private String userName;
    private String profileImg;
    private Long diaryId;
    private String diaryContent;
    private FeelingType feeling;
    private LocalDateTime createdDate;
    private Integer likesCount;

    @Builder @QueryProjection
    public DiaryDetailInfoCriteria(Diary diary,Long diaryId,
                                   String diaryContent,
                                   FeelingType feeling,
                                   String userName,
                                   String profileImg,
                                   LocalDateTime createdDate,
                                   Integer likesCount){
        this.diaryId = diaryId;
        this.diaryContent = diaryContent;
        this.feeling = feeling;
        this.userName = userName;
        this.profileImg = profileImg;
        this.createdDate = createdDate;
        this.likesCount = likesCount;
    }

}
