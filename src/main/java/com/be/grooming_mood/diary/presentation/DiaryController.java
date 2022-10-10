package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.command.DiaryCreateCommand;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryCommandService diaryCommandService;

//    @PostMapping("/{userId}")
//    public long createDiary(@PathVariable("userId") Long userId, @RequestBody DiaryCreateDto diaryCreateDto){
////        return diaryCommandService.create();
//    }
}
