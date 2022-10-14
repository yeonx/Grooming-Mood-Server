package com.be.grooming_mood.reaction.repository;

import com.be.grooming_mood.reaction.domain.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReactionRepository extends JpaRepository<Reaction, Long> {

}
