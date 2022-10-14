package com.be.grooming_mood.feeling.repository;

import com.be.grooming_mood.feeling.domain.FeelingHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeelingHistoryRepository extends JpaRepository<FeelingHistory, Long> {

}
