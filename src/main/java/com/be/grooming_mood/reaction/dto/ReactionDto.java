package com.be.grooming_mood.reaction.dto;

import com.be.grooming_mood.reaction.domain.ReactionType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReactionDto {

    private ReactionType reaction;
}
