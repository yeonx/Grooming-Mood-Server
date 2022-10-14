package com.be.grooming_mood.feeling.controller;

import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import com.be.grooming_mood.feeling.service.FeelingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class feelingController {
    private final FeelingHistoryService feelingService;

    @GetMapping("/feeling-history/{userId}")
    public List<FeelingHistoryDto> getFeelingHistoryInWeek(@PathVariable("userId") Long userId) {
        return feelingService.getFeelingHistory(userId);
    }

}
