package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.user.service.UserService;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "일기 등록")
    @PostMapping("/{userId}")
    public Long createDiary(@PathVariable("userId") Long userId, @Valid DiaryCreateDto diaryCreateDto){
        return diaryCommandService.create(userId, diaryCreateDto);
    }

    @ApiOperation(value ="내 일기 리스트")
    @GetMapping("/{userId}")
    public DiaryListQueryResult getMyDiaryList(@PathVariable("userId") Long userId){
        return diaryQueryService.findMyDiaryList(userId);
    }

    @ApiOperation(value ="내 일기 상세 보기")
    @GetMapping("/{diaryId}")
    public DiaryDetailInfoCriteria getDiaryInfo(@PathVariable long diaryId){
        return diaryQueryService.findDetailInfo(diaryId);
    }

    /* 수정 */
//    @PostMapping("/{diaryId}")
//    public void updateDiary(@PathVariable("diaryId") Long diaryId,@Valid DiaryUpdateCommand diaryUpdateCommand){
//        diaryCommandService.update(diaryId,diaryUpdateCommand);
//    }

}
