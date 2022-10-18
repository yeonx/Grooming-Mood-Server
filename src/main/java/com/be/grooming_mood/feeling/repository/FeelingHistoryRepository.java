package com.be.grooming_mood.feeling.repository;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.feeling.domain.FeelingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FeelingHistoryRepository extends JpaRepository<FeelingHistory, Long> {
//    List<FeelingHistory> findFeelingHistoryByUserId();
}
