package com.be.grooming_mood.feeling.repository;

import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeelingHistoryRepositoryCustom {
    List<FeelingHistoryDto> findAllFeelingHistoryInWeek(Long userId);
}
