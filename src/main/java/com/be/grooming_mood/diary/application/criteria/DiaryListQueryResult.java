package com.be.grooming_mood.diary.application.criteria;

import lombok.Getter;

import java.util.List;

@Getter
public class DiaryListQueryResult {
    private List<DiarySimpleInfoCriteria> diaryList;
    private boolean hasNext;
    private String nextCursor;

    public DiaryListQueryResult(List<DiarySimpleInfoCriteria> diaryList,boolean hasNext, String nextCursor ){
        this.diaryList = diaryList;
        this.hasNext = hasNext;
        this.nextCursor = nextCursor;
    }
}
