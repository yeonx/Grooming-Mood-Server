package com.be.grooming_mood.feeling.dto;

import com.be.grooming_mood.feeling.domain.FeelingType;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class FeelingHistoryCreateDto {

    private FeelingType feeling;

}

