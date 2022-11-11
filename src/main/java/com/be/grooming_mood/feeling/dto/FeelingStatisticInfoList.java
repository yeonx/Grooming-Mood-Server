package com.be.grooming_mood.feeling.dto;

import java.util.List;
import lombok.Getter;

@Getter
public class FeelingStatisticInfoList {
  private final List<FeelingStatisticInfo> feelingStatisticInfoList;

  public FeelingStatisticInfoList(List<FeelingStatisticInfo> feelingStatisticInfoList) {
    this.feelingStatisticInfoList = feelingStatisticInfoList;
  }
}
