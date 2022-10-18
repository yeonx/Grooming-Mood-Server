package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/my-diary")
public class MyDiaryController {

    private final DiaryQueryService diaryQueryService;
    private final DiaryCommandService diaryCommandService;
    private final UserService userService;

    @PostMapping("/{userId}")
    public Long createDiary(@PathVariable("userId") Long userId, @Valid DiaryCreateDto diaryCreateDto){
        return diaryCommandService.create(userId, diaryCreateDto);
    }

    @GetMapping("/{userId}")
    public DiaryListQueryResult getMyDiaryList(@PathVariable("userId") Long userId){
        return diaryQueryService.findMyDiaryList(userId);
    }

    @PostMapping("/{diaryId}")
    public void updateDiary(@PathVariable("diaryId") Long diaryId,@Valid DiaryUpdateCommand diaryUpdateCommand){
        diaryCommandService.update(diaryId,diaryUpdateCommand);
    }

}
