package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.application.criteria.DiarySimpleInfoCriteria;
import com.be.grooming_mood.diary.infra.DiaryQueryDao;
import com.be.grooming_mood.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.be.grooming_mood.exception.ErrorCode.DIARY_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class DiaryQueryService {

    private final DiaryQueryDao diaryQueryDao;

    @Transactional(readOnly = true)
    public DiarySimpleInfoCriteria findSimpleInfo(Long diaryId){
        return diaryQueryDao.findSimpleInfo(diaryId)
                .orElseThrow(() -> new NotFoundException(DIARY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public DiaryDetailInfoCriteria findDetailInfo(Long diaryId){
        return diaryQueryDao.findDetailInfo(diaryId)
                .orElseThrow(()-> new NotFoundException(DIARY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findMyDiaryList(long userId, String cursor,int size){
        return diaryQueryDao.findMyDiaryList(userId,cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findAllDiaryList(String cursor,int size){
        return diaryQueryDao.findAllDiaryList(cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findHappyDiaryList(String cursor,int size){
        return diaryQueryDao.findHappyDiaryList(cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findSadDiaryList(String cursor,int size){
        return diaryQueryDao.findSadDiaryList(cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findNormalDiaryList(String cursor,int size){
        return diaryQueryDao.findNormalDiaryList(cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findAngryDiaryList(String cursor,int size){
        return diaryQueryDao.findAngryDiaryList(cursor,size);
    }

}
