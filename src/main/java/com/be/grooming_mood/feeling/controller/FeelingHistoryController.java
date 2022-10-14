package com.be.grooming_mood.feeling.controller;

import com.be.grooming_mood.config.auth.LoginUser;
import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import com.be.grooming_mood.feeling.service.FeelingHistoryService;
import com.be.grooming_mood.user.domain.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
public class FeelingHistoryController {
    private final FeelingHistoryService feelingHistoryService;

//    @GetMapping("/feeling-history")
//    public List<FeelingHistoryDto> getFeelingHistoryInWeek(@LoginUser SessionUser user) {
//        return feelingHistoryService.getFeelingHistory(user.getId());
//    }

    @PostMapping("/feeling-history")
    public void createFeelingHistory(@LoginUser SessionUser user, @Valid FeelingHistoryCreateDto feelingHistoryCreateDto) {
        feelingHistoryService.createFeelingHistory(user.getId(), feelingHistoryCreateDto);
    }
}
