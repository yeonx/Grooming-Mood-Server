package com.be.grooming_mood.feeling.repository;

import com.be.grooming_mood.feeling.dto.FeelingHistoryInfo;
import com.be.grooming_mood.feeling.dto.FeelingHistoryInfoList;
import com.be.grooming_mood.feeling.dto.FeelingStatisticInfo;
import com.be.grooming_mood.feeling.dto.FeelingStatisticInfoList;
import com.be.grooming_mood.feeling.dto.QFeelingHistoryInfo;
import com.be.grooming_mood.feeling.dto.QFeelingStatisticInfo;
import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.be.grooming_mood.feeling.domain.QFeelingHistory.feelingHistory;
import static com.be.grooming_mood.feeling.dto.QFeelingHistoryInfo.*;
import static com.be.grooming_mood.user.domain.QUser.user;

@RequiredArgsConstructor
@Repository
public class FeelingHistoryQueryDao {
    private final JPAQueryFactory jpaQueryFactory;

    public FeelingHistoryInfoList findAllFeelingHistoryInThisMonth(LocalDateTime start, LocalDateTime end) {
        List<FeelingHistoryInfo> infoList =
                jpaQueryFactory.select(new QFeelingHistoryInfo(feelingHistory.id, user.id, feelingHistory.feeling, feelingHistory.createdDate))
                .from(feelingHistory)
                .where(feelingHistory.createdDate.between(start, end))
                .fetch();

        return new FeelingHistoryInfoList(infoList);
    }

    public FeelingStatisticInfoList findAllFeelingStatisticsInLastWeek(Long userId, LocalDateTime start, LocalDateTime end) {

        List<FeelingStatisticInfo> infoList =
            jpaQueryFactory.select(new QFeelingStatisticInfo(feelingHistory.feeling, feelingHistory.feeling.count()))
                .from(feelingHistory)
                .where(feelingHistory.user.id.eq(userId))
                .where(feelingHistory.createdDate.between(start, end))
                .groupBy(feelingHistory.feeling)
                .fetch();

        return new FeelingStatisticInfoList(infoList);
    }

//    select feelinghis0_.feeling as col_0_0_, count(feelinghis0_.feeling) as col_1_0_ from feeling_history feelinghis0_ where feelinghis0_.user_id=1 and (feelinghis0_.created_date between '2022-11-07T17:13:21.775+0900' and '2022-11-11T17:13:21.775+0900') group by feelinghis0_.feeling;
    public FeelingStatisticInfoList findAllFeelingStatisticsInThisWeek(Long userId, LocalDateTime start, LocalDateTime end) {

        List<FeelingStatisticInfo> infoList =
            jpaQueryFactory.select(new QFeelingStatisticInfo(feelingHistory.feeling, feelingHistory.feeling.count()))
                .from(feelingHistory)
                .where(feelingHistory.user.id.eq(userId))
                .where(feelingHistory.createdDate.between(start, end))
                .groupBy(feelingHistory.feeling)
                .fetch();

        System.out.println(infoList);
        return new FeelingStatisticInfoList(infoList);
    }

}
