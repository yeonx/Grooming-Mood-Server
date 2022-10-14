package com.be.grooming_mood.feeling.controller;

import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import com.be.grooming_mood.feeling.service.FeelingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeelingController {
    private final FeelingHistoryService feelingHistoryService;

    @GetMapping("/feeling-history/{userId}")
    public List<FeelingHistoryDto> getFeelingHistoryInWeek(@PathVariable("userId") Long userId) {
        return feelingHistoryService.getFeelingHistory(userId);
    }

    @PostMapping("/feeling-history/{userId}")
    public void createFeelingHistory(@PathVariable("userId") Long userId, @Valid FeelingHistoryCreateDto feelingHistoryCreateDto) {
        feelingHistoryService.createFeelingHistory(userId, feelingHistoryCreateDto);
    }
}
