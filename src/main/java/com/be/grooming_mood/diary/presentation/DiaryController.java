package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.diary.presentation.dto.DiaryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    
    private final DiaryCommandService diaryCommandService;
    private final DiaryDtoMapper diaryDtoMapper;

    @PostMapping("/{userId}")
    public long createDiary(@PathVariable("userId") Long userId, @RequestBody DiaryCreateDto diaryCreateDto){
        return diaryCommandService.create(userId, diaryDtoMapper.toCreateCommand(diaryCreateDto));
    }


    @DeleteMapping("/{userId}/{diaryId}")
    public void deleteDiary(@PathVariable("diaryId") Long diaryId){
        diaryCommandService.delete(diaryId);
    }
}
