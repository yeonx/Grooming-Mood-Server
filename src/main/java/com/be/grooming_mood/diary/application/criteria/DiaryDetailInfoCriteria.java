package com.be.grooming_mood.diary.application.criteria;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.feeling.domain.FeelingType;
import com.be.grooming_mood.user.domain.User;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class DiaryDetailInfoCriteria {
    private String userName;
    private String profileImg;
    private Long diaryId;
    private String diaryContent;
    private FeelingType feeling;

//    @QueryProjection
//    public DiaryDetailInfoCriteria(Diary diary, User user){
//        this.diaryId = diary.getId();
//        this.diaryContent = diary.getDiaryContent();
//        this.feeling = diary.getFeeling();
//        this.userName = user.getName();
//        this.profileImg = user.getProfileImg();
//
//    }

    @Builder @QueryProjection
    public DiaryDetailInfoCriteria(Long diaryId,
                                   String diaryContent,
                                   FeelingType feeling,
                                   String userName,
                                   String profileImg){
        this.diaryId = diaryId;
        this.diaryContent = diaryContent;
        this.feeling = feeling;
        this.userName = userName;
        this.profileImg = profileImg;
    }

}
