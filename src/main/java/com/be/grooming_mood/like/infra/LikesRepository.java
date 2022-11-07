package com.be.grooming_mood.like.infra;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.like.domain.Likes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface LikesRepository extends JpaRepository<Likes, Long>,LikesCustomRepository {
    @Modifying
    @Query(value = "INSERT INTO likes(diary_id, user_id) VALUES(:diaryId, :userId)", nativeQuery = true)
    void likes(long diaryId, long userId);

    @Modifying
    @Query(value = "DELETE FROM likes WHERE diary_id = :diaryId AND user_id = :userId", nativeQuery = true)
    void unLikes(long diaryId, long userId);

    List<Likes> findAllByDiary(Diary diary);

}
