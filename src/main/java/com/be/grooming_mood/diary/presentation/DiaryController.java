package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.diary.presentation.dto.DiaryDtoMapper;
import com.be.grooming_mood.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    
    private final DiaryCommandService diaryCommandService;
    private final DiaryDtoMapper diaryDtoMapper;

    @PostMapping("/{userId}")
    public long createDiary(@PathVariable("userId") Long userId,@Valid DiaryCreateDto diaryCreateDto){
        return diaryCommandService.create(userId, diaryDtoMapper.toCreateCommand(diaryCreateDto));
    }

    @PostMapping("/{userId}/{diaryId}")
    public void updateDiary(@PathVariable("userId") Long userId, @PathVariable("diaryId") Long diaryId
            , Authentication authentication, @Valid DiaryUpdateCommand diaryUpdateCommand){
//        try{
//            User user = (User) authentication.getPrincipal();
//            if (user.getId() == userId) {
//                diaryCommandService.update(diaryId,diaryUpdateCommand);
//            }else{
//
//            }
//        } catch (Exception e) {
//
//        }
        diaryCommandService.update(diaryId,diaryUpdateCommand);
    }


    @DeleteMapping("/{userId}/{diaryId}")
    public void deleteDiary(@PathVariable("diaryId") Long diaryId){
        diaryCommandService.delete(diaryId);
    }
}
