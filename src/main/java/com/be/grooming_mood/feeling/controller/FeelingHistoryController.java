package com.be.grooming_mood.feeling.controller;

import com.be.grooming_mood.feeling.dto.FeelingHistoryDto;
import com.be.grooming_mood.oauth.LoginUser;
import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import com.be.grooming_mood.feeling.service.FeelingHistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feeling-history")
public class FeelingHistoryController {
    private final FeelingHistoryService feelingHistoryService;

//    @GetMapping("/feeling-history")
//    public List<FeelingHistoryDto> getFeelingHistoryInWeek() {
//        return feelingHistoryService.getFeelingHistory(user.getId());
//    }

    @PostMapping("")
    public void createFeelingHistory(@Valid @RequestBody FeelingHistoryCreateDto feelingHistoryCreateDto) {
        feelingHistoryService.createFeelingHistory(feelingHistoryCreateDto);
    }
}
