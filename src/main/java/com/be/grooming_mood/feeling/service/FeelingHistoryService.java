package com.be.grooming_mood.feeling.service;

import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import com.be.grooming_mood.feeling.repository.FeelingHistoryRepository;
import com.be.grooming_mood.feeling.repository.FeelingHistoryRepositoryCustom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FeelingHistoryService {

    private final FeelingHistoryRepository feelingHistoryRepository;
    private final FeelingHistoryRepositoryCustom feelingHistoryRepositoryCustom;


    @Transactional(readOnly = true)
    public List<FeelingHistoryDto> getFeelingHistory(Long userId){

        return feelingHistoryRepositoryCustom.findAllFeelingHistoryInWeek(userId);
    }
}
