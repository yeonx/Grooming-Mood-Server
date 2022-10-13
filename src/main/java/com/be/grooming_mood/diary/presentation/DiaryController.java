package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.diary.presentation.dto.DiaryDtoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryQueryService diaryQueryService;
    private final DiaryCommandService diaryCommandService;
    private final DiaryDtoMapper diaryDtoMapper;

    @PostMapping("/{userId}")
    public long createDiary(@PathVariable("userId") Long userId,@Valid DiaryCreateDto diaryCreateDto){
        return diaryCommandService.create(userId, diaryDtoMapper.toCreateCommand(diaryCreateDto));
    }

    @PostMapping("/{userId}/{diaryId}")
    public void updateDiary(@PathVariable("diaryId") Long diaryId,@Valid DiaryUpdateCommand diaryUpdateCommand){
        diaryCommandService.update(diaryId,diaryUpdateCommand);
    }

    @DeleteMapping("/{userId}/{diaryId}")
    public void deleteDiary(@PathVariable("diaryId") Long diaryId){
        diaryCommandService.delete(diaryId);
    }

    @GetMapping("/{userId}/{diaryId}")
    public DiaryDetailInfoCriteria getDiaryInfo(@PathVariable long diaryId){
        return diaryQueryService.findDetailInfo(diaryId);
    }

    @GetMapping("/{userId}")
    public DiaryListQueryResult getMyDiaryList(@PathVariable long userId,
                                               @RequestParam(required = false) String cursor,
                                               @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findMyDiaryList(userId,cursor,size);
    }

}
