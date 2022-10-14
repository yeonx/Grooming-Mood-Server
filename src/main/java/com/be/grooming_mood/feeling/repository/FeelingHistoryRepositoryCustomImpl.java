//package com.be.grooming_mood.feeling.repository;
//
//
//import com.be.grooming_mood.feeling.domain.QFeelingHistory;
//import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
//import com.querydsl.jpa.impl.JPAQueryFactory;
//import org.springframework.stereotype.Repository;
//
//import javax.persistence.EntityManager;
//import java.util.List;
//
//import static com.be.grooming_mood.feeling.domain.QFeelingHistory.feelingHistory;
//
//
//@Repository
//public class FeelingHistoryRepositoryCustomImpl implements FeelingHistoryRepository {
//
//    private final JPAQueryFactory queryFactory;
//
//    public FeelingHistoryRepositoryCustomImpl(EntityManager entityManager){
//        this.queryFactory = new JPAQueryFactory(entityManager);
//    }
//
//
//    public List<FeelingHistoryDto> findAllFeelingHistoryInWeek(Long userId){
//        return queryFactory.select(new QFeelingHistory(feelingHistory.id, feelingHistory.feeling, feelingHistory.createdDate))
//                .from(feelingHistory)
//                .where(feelingHistory.user.id.eq(userId))
//                .orderBy(feelingHistory.createdDate.asc());
//
//    }
//
//}
