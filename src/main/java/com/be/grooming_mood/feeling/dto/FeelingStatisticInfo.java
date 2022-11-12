package com.be.grooming_mood.feeling.dto;

import com.be.grooming_mood.feeling.domain.FeelingType;
import com.querydsl.core.annotations.QueryProjection;
import lombok.Builder;
import lombok.Getter;

@Getter
public class FeelingStatisticInfo {
  private FeelingType feeling;
  private Long amount;

  @QueryProjection @Builder
  public FeelingStatisticInfo(FeelingType feeling, Long amount){
    this.feeling = feeling;
    this.amount = amount;
  }
}
