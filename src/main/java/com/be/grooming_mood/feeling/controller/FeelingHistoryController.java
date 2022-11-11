package com.be.grooming_mood.feeling.controller;

import com.be.grooming_mood.feeling.domain.FeelingHistory;
import com.be.grooming_mood.feeling.dto.FeelingHistoryInfo;
import com.be.grooming_mood.feeling.dto.FeelingHistoryInfoList;
import com.be.grooming_mood.feeling.service.FeelingHistoryService;
import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/feeling-history")
public class FeelingHistoryController {

    private final FeelingHistoryService feelingHistoryService;

    @ApiOperation(value ="월별 감정 히스토리 조회(사용 X)")
    @GetMapping("/userId/{userId}")
    public FeelingHistoryInfoList getFeelingHistoryInMonth(@PathVariable("userId") Long userId) {
        return feelingHistoryService.getFeelingHistoryList(userId);
    }

    @ApiOperation(value ="감정 히스토리 생성")
    @PostMapping("")
    public String createFeelingHistory(@Valid @RequestBody FeelingHistoryCreateDto feelingHistoryCreateDto) {
        return feelingHistoryService.createFeelingHistory(feelingHistoryCreateDto);
    }
}
