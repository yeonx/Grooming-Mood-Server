package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryCommandService;
import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import com.be.grooming_mood.diary.presentation.dto.DiaryCreateDto;
import com.be.grooming_mood.diary.presentation.dto.DiaryDtoMapper;
import com.be.grooming_mood.user.domain.SessionUser;
import io.swagger.annotations.ApiOperation;
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

    @ApiOperation(value = "일기 등록")
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
        return diaryQueryService.findMyDiaryList(user.getId());
    }

    @GetMapping("/all-paging")
    public DiaryListQueryResult getAllDiaryList(){
        return diaryQueryService.findAllDiaryList();
    }

    @GetMapping("/happy-paging")
    public DiaryListQueryResult getHappyDiaryList(){
        return diaryQueryService.findHappyDiaryList();
    }
    @GetMapping("/sad-paging")
    public DiaryListQueryResult getSadDiaryList(){
        return diaryQueryService.findSadDiaryList();
    }

    @GetMapping("/normal-paging")
    public DiaryListQueryResult getNormalDiaryList(){
        return diaryQueryService.findNormalDiaryList();
    }

    @GetMapping("/angry-paging")
    public DiaryListQueryResult getAngryDiaryList(){
        return diaryQueryService.findAngryDiaryList();
    }

//    @GetMapping("/my-page")
//    public DiaryListQueryResult getMyDiaryList(@RequestParam(required = false) String cursor,
//                                               @RequestParam(required = false, defaultValue = "10") int size){
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        return diaryQueryService.findMyDiaryList(user.getId(),cursor,size);
//    }
//
//    @GetMapping("/all-paging")
//    public DiaryListQueryResult getAllDiaryList(@RequestParam(required = false) String cursor,
//                                               @RequestParam(required = false, defaultValue = "10") int size){
//        return diaryQueryService.findAllDiaryList(cursor,size);
//    }
//
//    @GetMapping("/happy-paging")
//    public DiaryListQueryResult getHappyDiaryList(@RequestParam(required = false) String cursor,
//                                                @RequestParam(required = false, defaultValue = "10") int size){
//        return diaryQueryService.findHappyDiaryList(cursor,size);
//    }
//
//    @GetMapping("/sad-paging")
//    public DiaryListQueryResult getSadDiaryList(@RequestParam(required = false) String cursor,
//                                                  @RequestParam(required = false, defaultValue = "10") int size){
//        return diaryQueryService.findSadDiaryList(cursor,size);
//    }
//
//    @GetMapping("/normal-paging")
//    public DiaryListQueryResult getNormalDiaryList(@RequestParam(required = false) String cursor,
//                                                @RequestParam(required = false, defaultValue = "10") int size){
//        return diaryQueryService.findNormalDiaryList(cursor,size);
//    }
//
//    @GetMapping("/angry-paging")
//    public DiaryListQueryResult getAngryDiaryList(@RequestParam(required = false) String cursor,
//                                                   @RequestParam(required = false, defaultValue = "10") int size){
//        return diaryQueryService.findAngryDiaryList(cursor,size);
//    }

}
