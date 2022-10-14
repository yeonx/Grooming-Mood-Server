package com.be.grooming_mood.feeling.dto;

import com.be.grooming_mood.feeling.domain.FeelingType;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor(access= AccessLevel.PROTECTED)
public class FeelingHistoryDto {

    private Long id;
    private FeelingType feeling;
    private LocalDateTime createdDate;

    @Builder
    public FeelingHistoryDto(
            FeelingType feeling,
            LocalDateTime createdDate){
        this.feeling = feeling;
        this.createdDate = createdDate;

    }
}
