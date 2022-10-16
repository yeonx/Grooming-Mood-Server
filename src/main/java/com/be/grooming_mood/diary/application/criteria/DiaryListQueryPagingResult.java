package com.be.grooming_mood.diary.application.criteria;

import lombok.Getter;

import java.util.List;

@Getter
public class DiaryListQueryPagingResult {
    private List<DiarySimpleInfoCriteria> diaryList;
    private boolean hasNext;
    private String nextCursor;

    public DiaryListQueryPagingResult(List<DiarySimpleInfoCriteria> diaryList,boolean hasNext, String nextCursor ){
        this.diaryList = diaryList;
        this.hasNext = hasNext;
        this.nextCursor = nextCursor;
    }
}
