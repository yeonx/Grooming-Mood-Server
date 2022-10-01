package com.be.grooming_mood.diary.infra;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@RequiredArgsConstructor
@Repository
public class DiaryJpaRepository implements DiaryRepository {
    private final JPAQueryFactory queryFactory;
    private final EntityManager entityManager;
    @Override
    public void save(Diary diary) {
        entityManager.persist(diary);
    }

}
