package com.be.grooming_mood.like.infra;

import com.be.grooming_mood.like.domain.Likes;
import com.querydsl.jpa.impl.JPAQueryFactory;

import javax.persistence.EntityManager;
import java.util.Optional;

import static com.be.grooming_mood.like.domain.QLikes.likes;

public class LikesCustomRepositoryImpl implements LikesCustomRepository{

    JPAQueryFactory jpaQueryFactory;

    public LikesCustomRepositoryImpl(EntityManager em) {
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }

    public Optional<Likes> exist(Long userId, Long diaryId) {
        Likes pLike = jpaQueryFactory
                .selectFrom(likes)
                .where(likes.user.id.eq(userId),
                        likes.diary.id.eq(diaryId))
                .fetchFirst();

        return Optional.ofNullable(pLike);
    }

    public long findLikesNum(Long diaryId) {
        return jpaQueryFactory
                .selectFrom(likes)
                .where(likes.diary.id.eq(diaryId))
                .fetchCount();
    }

}
