package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryPagingResult;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.application.criteria.DiarySimpleInfoCriteria;
import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryJpaInterfaceRepository;
import com.be.grooming_mood.diary.infra.DiaryQueryDao;
import com.be.grooming_mood.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.be.grooming_mood.exception.ErrorCode.DIARY_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class DiaryQueryService {

    private final DiaryQueryDao diaryQueryDao;
    private final DiaryJpaInterfaceRepository diaryJpaInterfaceRepository;

    @Transactional(readOnly = true)
    public DiarySimpleInfoCriteria findSimpleInfo(Long diaryId){
        Optional<Diary> diaryCheck = diaryJpaInterfaceRepository.findById(diaryId);
        Diary diary = diaryCheck.orElseThrow(() ->
                new NotFoundException(DIARY_NOT_FOUND));
        return diaryQueryDao.findSimpleInfo(diaryId)
                .orElseThrow(() -> new NotFoundException(DIARY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public DiaryDetailInfoCriteria findDetailInfo(Long diaryId){
        Optional<Diary> diaryCheck = diaryJpaInterfaceRepository.findById(diaryId);
        Diary diary = diaryCheck.orElseThrow(() ->
                new NotFoundException(DIARY_NOT_FOUND));
        return diaryQueryDao.findDetailInfo(diaryId)
                .orElseThrow(()-> new NotFoundException(DIARY_NOT_FOUND));
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findMyDiaryList(long userId){
        return diaryQueryDao.findMyDiaryList(userId);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryPagingResult findAllDiaryList(String cursor, int size){
        return diaryQueryDao.findAllDiaryListPaging(cursor,size);
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findAllDiaryList(){
        return diaryQueryDao.findAllDiaryList();
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findHappyDiaryList(){
        return diaryQueryDao.findHappyDiaryList();
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findSadDiaryList(){
        return diaryQueryDao.findSadDiaryList();
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findNormalDiaryList(){
        return diaryQueryDao.findNormalDiaryList();
    }

    @Transactional(readOnly = true)
    public DiaryListQueryResult findAngryDiaryList(){
        return diaryQueryDao.findAngryDiaryList();
    }

//    @Transactional(readOnly = true)
//    public DiaryListQueryPagingResult findHappyDiaryList(String cursor,int size){
//        return diaryQueryDao.findHappyDiaryList(cursor,size);
//    }
//    @Transactional(readOnly = true)
//    public DiaryListQueryPagingResult findSadDiaryList(String cursor,int size){
//        return diaryQueryDao.findSadDiaryList(cursor,size);
//    }
//
//    @Transactional(readOnly = true)
//    public DiaryListQueryPagingResult findNormalDiaryList(String cursor,int size){
//        return diaryQueryDao.findNormalDiaryList(cursor,size);
//    }
//
//    @Transactional(readOnly = true)
//    public DiaryListQueryPagingResult findAngryDiaryList(String cursor,int size){
//        return diaryQueryDao.findAngryDiaryList(cursor,size);
//    }

}
