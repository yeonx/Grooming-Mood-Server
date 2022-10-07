package com.be.grooming_mood.diary.infra;

import com.be.grooming_mood.diary.application.criteria.DiarySimpleInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.QDiarySimpleInfoCriteria;
import com.be.grooming_mood.diary.domain.QDiary;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

import static com.be.grooming_mood.diary.domain.QDiary.diary;
import static com.querydsl.core.group.GroupBy.groupBy;

@RequiredArgsConstructor
@Repository
public class DiaryQueryDao {
    private final JPAQueryFactory queryFactory;

    public Optional<DiarySimpleInfoCriteria> findSimpleInfo(long diaryId){
        return Optional.ofNullable(
                queryFactory
                        .from(diary)
                        .where(diary.id.eq(diaryId))
                        .transform(
                                groupBy(diary.id).as(
                                        new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent)
                                )
                        )
                        .get(diaryId)
        );
    }

}
