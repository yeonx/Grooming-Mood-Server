package com.be.grooming_mood.reaction.repository;

import com.be.grooming_mood.reaction.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

    Integer countByDiaryId(Long diaryId);

    Optional<Reaction> findByDiaryIdAndUserId(Long diaryId, Long userId);
}
