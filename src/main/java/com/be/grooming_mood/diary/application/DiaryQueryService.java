package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.criteria.DiarySimpleInfoCriteria;
import com.be.grooming_mood.diary.infra.DiaryQueryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryQueryService {

    private final DiaryQueryDao diaryQueryDao;

    @Transactional(readOnly = true)
    public DiarySimpleInfoCriteria findSimpleInfo(long diaryId){
        return diaryQueryDao.findSimpleInfo(diaryId)
                .orElseThrow();
    }


}
