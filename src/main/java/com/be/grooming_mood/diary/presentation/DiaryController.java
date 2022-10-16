package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.diary.presentation.dto.DiaryDtoMapper;
import com.be.grooming_mood.user.domain.SessionUser;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
public class DiaryController {
    private final DiaryQueryService diaryQueryService;
    private final DiaryCommandService diaryCommandService;
    private final DiaryDtoMapper diaryDtoMapper;
    private final HttpSession httpSession;

    @PostMapping("/my-page")
    public long createDiary( @Valid DiaryCreateDto diaryCreateDto){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return diaryCommandService.create(user.getId(), diaryDtoMapper.toCreateCommand(diaryCreateDto));
    }

    @PostMapping("/my-page/{diaryId}")
    public void updateDiary(@PathVariable("diaryId") Long diaryId,@Valid DiaryUpdateCommand diaryUpdateCommand){
        diaryCommandService.update(diaryId,diaryUpdateCommand);
    }

    @DeleteMapping("/{diaryId}")
    public void deleteDiary(@PathVariable("diaryId") Long diaryId){
        diaryCommandService.delete(diaryId);
    }

    @GetMapping("/{diaryId}")
    public DiaryDetailInfoCriteria getDiaryInfo(@PathVariable long diaryId){
        return diaryQueryService.findDetailInfo(diaryId);
    }

    @GetMapping("/my-page")
    public DiaryListQueryResult getMyDiaryList(@RequestParam(required = false) String cursor,
                                               @RequestParam(required = false, defaultValue = "10") int size){
        SessionUser user = (SessionUser) httpSession.getAttribute("user");
        return diaryQueryService.findMyDiaryList(user.getId(),cursor,size);
    }

    @GetMapping("/all")
    public DiaryListQueryResult getAllDiaryList(@RequestParam(required = false) String cursor,
                                               @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findAllDiaryList(cursor,size);
    }

    @GetMapping("/happy")
    public DiaryListQueryResult getHappyDiaryList(@RequestParam(required = false) String cursor,
                                                @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findHappyDiaryList(cursor,size);
    }

    @GetMapping("/sad")
    public DiaryListQueryResult getSadDiaryList(@RequestParam(required = false) String cursor,
                                                  @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findSadDiaryList(cursor,size);
    }

    @GetMapping("/normal")
    public DiaryListQueryResult getNormalDiaryList(@RequestParam(required = false) String cursor,
                                                @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findNormalDiaryList(cursor,size);
    }

    @GetMapping("/angry")
    public DiaryListQueryResult getAngryDiaryList(@RequestParam(required = false) String cursor,
                                                   @RequestParam(required = false, defaultValue = "10") int size){
        return diaryQueryService.findAngryDiaryList(cursor,size);
    }

}
