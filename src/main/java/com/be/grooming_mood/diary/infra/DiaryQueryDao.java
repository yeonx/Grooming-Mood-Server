package com.be.grooming_mood.diary.infra;

import com.be.grooming_mood.diary.application.criteria.*;
import com.be.grooming_mood.diary.domain.DiaryJpaInterfaceRepository;
import com.be.grooming_mood.exception.ErrorCode;
import com.be.grooming_mood.exception.NotFoundException;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.StringExpressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static com.be.grooming_mood.diary.domain.QDiary.diary;
import static com.be.grooming_mood.exception.ErrorCode.DIARY_NOT_FOUND;
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
                                        new QDiarySimpleInfoCriteria(diary, diary.id, diary.diaryContent,
                                                user.name, user.profileImg, diary.feeling, diary.createdDate)
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
                                        new QDiaryDetailInfoCriteria(diary,diary.id, diary.diaryContent, diary.feeling,
                                                user.name, user.profileImg, diary.createdDate)
                                )
                        ).get(diaryId)
        );
    }
    public DiaryListQueryPagingResult findMyDiaryListPaging(Long userId, String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(user.id.eq(userId),diaryIdCursorCondition(cursor))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .fetch();
        hasDataCheck(infoList);

        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    public DiaryListQueryPagingResult findAllDiaryListPaging(String cursor, int size){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diaryIdCursorCondition(cursor))
                .limit(size + 1)
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        hasDataCheck(infoList);

        boolean hasNext = hasNext(size, infoList);
        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
    }

    public DiaryListQueryResult findAllDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryResult findHappyDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diary.feeling.eq(HAPPY))
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryResult findSadDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diary.feeling.eq(SAD))
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryResult findNormalDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diary.feeling.eq(NORMAL))
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    public DiaryListQueryResult findAngryDiaryList(){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(diary.feeling.eq(ANGRY))
                .where(diary.isPublic.isTrue())
                .orderBy(diary.id.desc())
                .offset(1)
                .fetch();
        return new DiaryListQueryResult(infoList);
    }

    private String getDiaryIdNextCursor(List<DiarySimpleInfoCriteria> infoList){
        long lastDiaryId = infoList.get(infoList.size() - 1).getDiaryId();
        return String.format("%020d",lastDiaryId);
    }

    private boolean hasNext(int size, List<DiarySimpleInfoCriteria> infoList){
        boolean hasNext = false;
        if(infoList.size() >size){
            infoList.remove(size);
            hasNext = true;
        }
        return hasNext;
    }

    private void hasDataCheck(List<DiarySimpleInfoCriteria> infoList) {
        if(infoList.size() == 0)
            throw new NotFoundException(DIARY_NOT_FOUND);
    }

    private BooleanExpression diaryIdCursorCondition(String cursor) {
        if(cursorValidate(cursor)) return null;
        return StringExpressions.lpad(diary.id.stringValue(), 20, '0')
                .lt(cursor);
    }
    private boolean cursorValidate(String cursor) {
        return cursor == null || cursor.length() < 20;
    }

    public DiaryListQueryResult findMyDiaryList(Long userId){
        List<DiarySimpleInfoCriteria> infoList = queryFactory
                .select(new QDiarySimpleInfoCriteria(diary,diary.id, diary.diaryContent,
                        user.name, user.profileImg, diary.feeling, diary.createdDate))
                .from(diary)
                .where(user.id.eq(userId))
                .orderBy(diary.id.desc())
                .offset(1)
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
//public DiaryListQueryPagingResult findSadDiaryList(String cursor, int size){
//    List<DiarySimpleInfoCriteria> infoList = queryFactory
//            .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
//                    user.name, user.profileImg, diary.feeling))
//            .from(diary)
//            .where(diary.feeling.eq(SAD))
//            .limit(size + 1)
//            .orderBy(diary.id.desc())
//            .fetch();
//    boolean hasNext = hasNext(size, infoList);
//    String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
//    return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
//}

//    public DiaryListQueryPagingResult findNormalDiaryList(String cursor, int size){
//        List<DiarySimpleInfoCriteria> infoList = queryFactory
//                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
//                        user.name, user.profileImg, diary.feeling))
//                .from(diary)
//                .where(diary.feeling.eq(NORMAL))
//                .limit(size + 1)
//                .orderBy(diary.id.desc())
//                .fetch();
//        boolean hasNext = hasNext(size, infoList);
//        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
//        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
//    }

//    public DiaryListQueryPagingResult findAngryDiaryList(String cursor, int size){
//        List<DiarySimpleInfoCriteria> infoList = queryFactory
//                .select(new QDiarySimpleInfoCriteria(diary.id, diary.diaryContent,
//                        user.name, user.profileImg, diary.feeling))
//                .from(diary)
//                .where(diary.feeling.eq(ANGRY))
//                .limit(size + 1)
//                .orderBy(diary.id.desc())
//                .fetch();
//        boolean hasNext = hasNext(size, infoList);
//        String nextCursor = hasNext ? getDiaryIdNextCursor(infoList) : null;
//        return new DiaryListQueryPagingResult(infoList,hasNext,nextCursor);
//    }
}
