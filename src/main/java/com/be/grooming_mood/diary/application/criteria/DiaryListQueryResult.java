package com.be.grooming_mood.diary.application.criteria;

import lombok.Getter;

import java.util.List;

@Getter
public class DiaryListQueryResult {
    private List<DiarySimpleInfoCriteria> diaryList;

    public DiaryListQueryResult(List<DiarySimpleInfoCriteria> diaryList){
        this.diaryList = diaryList;
    }
}
