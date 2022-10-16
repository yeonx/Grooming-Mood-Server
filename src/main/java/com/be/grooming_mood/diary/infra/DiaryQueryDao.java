package com.be.grooming_mood.diary.infra;

import com.be.grooming_mood.diary.application.criteria.*;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.be.grooming_mood.diary.domain.QDiary.diary;
import static com.be.grooming_mood.feeling.domain.FeelingType.*;
import static com.be.grooming_mood.user.domain.QUser.user;
import static com.querydsl.core.group.GroupBy.groupBy;

@RequiredArgsConstructor
@Repository
public class DiaryQueryDao {
    private final JPAQueryFactory queryFactory;

    public Optional<DiarySimpleInfoCriteria> findSimpleInfo(Long diaryId){
        return Optional.ofNullable(
                queryFactory
                        .from(diary)
                        .where(diary.id.eq(diaryId))
                        .leftJoin(user).on(user.id.eq(diary.user.id))
                        .transform(
                                groupBy(diary.id).as(
                                        new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                                                user.name, user.profileImg, diary.feeling)
                                )
                        ).get(diaryId)
        );
    }

    public Optional<DiaryDetailInfoCriteria> findDetailInfo(Long diaryId){
        return Optional.ofNullable(
                queryFactory
                        .from(diary)
                        .where(diary.id.eq(diaryId))
                        .leftJoin(user).on(user.id.eq(diary.user.id))
                        .transform(
                                groupBy(diary.id).as(
                                        new QDiaryDetailInfoCriteria(diary.id, diary.diaryContent, diary.feeling,
                                                user.name, user.profileImg)
                                )
                        ).get(diaryId)
        );
    }
    public DiaryListQueryPagingResult findMyDiaryListPaging(Long userId, String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(user.id.eq(userId))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }
    public DiaryListQueryResult findMyDiaryList(Long userId){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(user.id.eq(userId))
                .orderBy(diary.id.desc())
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryPagingResult findAllDiaryListPaging(String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    public DiaryListQueryResult findAllDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

//    public DiaryListQueryPagingResult findHappyDiaryList(String cursor, int size){
//        List<DiarySimpleInfoCriteria> infoList = queryFactory
//                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
//                        user.name, user.profileImg, diary.feeling))
//                .from(diary)
//                .where(diary.feeling.eq(HAPPY))
//                .limit(size + 1)
//                .orderBy(diary.id.desc())
//                .fetch();
//        boolean hasNext = hasNext(size, infoList);
//        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
//        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
//    }
    public DiaryListQueryResult findHappyDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(diary.feeling.eq(HAPPY))
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryPagingResult findSadDiaryList(String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(diary.feeling.eq(SAD))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    public DiaryListQueryPagingResult findNormalDiaryList(String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(diary.feeling.eq(NORMAL))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    public DiaryListQueryPagingResult findAngryDiaryList(String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling))
                .from(diary)
                .where(diary.feeling.eq(ANGRY))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    private boolean hasNext(int size, List<DiarySimpleInfoCriteria> infoList){
        boolean hasNext = false;
        if(infoList.size() >size){
            infoList.remove(size);
            hasNext = true;
        }
        return hasNext;
    }

    private String getDiaryIdNextCursor(List<DiarySimpleInfoCriteria> infoList){
        long lastDiaryId = infoList.get(infoList.size() - 1).getDiaryId();
        return String.format("%020d",lastDiaryId);
    }

}
