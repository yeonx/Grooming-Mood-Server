package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feed-diary")
public class FeedDiaryController {
    private final DiaryQueryService diaryQueryService;

    @ApiOperation(value ="전체 일기 조회")
    @GetMapping("/all")
    public DiaryListQueryResult getAllDiaryList(){
        return diaryQueryService.findAllDiaryList();
    }

    @ApiOperation(value ="행복 일기 조회")
    @GetMapping("/happy")
    public DiaryListQueryResult getHappyDiaryList(){
        return diaryQueryService.findHappyDiaryList();
    }
    @ApiOperation(value ="슬픔 일기 조회")
    @GetMapping("/sad")
    public DiaryListQueryResult getSadDiaryList(){
        return diaryQueryService.findSadDiaryList();
    }

    @ApiOperation(value ="평범 일기 조회")
    @GetMapping("/normal")
    public DiaryListQueryResult getNormalDiaryList(){
        return diaryQueryService.findNormalDiaryList();
    }

    @ApiOperation(value ="화남 일기 조회")
    @GetMapping("/angry")
    public DiaryListQueryResult getAngryDiaryList(){
        return diaryQueryService.findAngryDiaryList();
    }

/**
 * 페이징
 */
//    @GetMapping("/my-page")
//    public DiaryListQueryPagingResult getMyDiaryList(@RequestParam(required = false) String cursor,
//                                               @RequestParam(required = false, defaultValue = "10") int size){
//        SessionUser user = (SessionUser) httpSession.getAttribute("user");
//        return DiaryListQueryPagingResult.findMyDiaryList(user.getId(),cursor,size);
//    }
//
//    @GetMapping("/all-paging")
//    public DiaryListQueryPagingResult getAllDiaryList(@RequestParam(required = false) String cursor,
//                                               @RequestParam(required = false, defaultValue = "10") int size){
//        return DiaryListQueryPagingResult.findAllDiaryList(cursor,size);
//    }
//
//    @GetMapping("/happy-paging")
//    public DiaryListQueryPagingResult getHappyDiaryList(@RequestParam(required = false) String cursor,
//                                                @RequestParam(required = false, defaultValue = "10") int size){
//        return DiaryListQueryPagingResult.findHappyDiaryList(cursor,size);
//    }
//
//    @GetMapping("/sad-paging")
//    public DiaryListQueryPagingResult getSadDiaryList(@RequestParam(required = false) String cursor,
//                                                  @RequestParam(required = false, defaultValue = "10") int size){
//        return DiaryListQueryPagingResult.findSadDiaryList(cursor,size);
//    }
//
//    @GetMapping("/normal-paging")
//    public DiaryListQueryPagingResult getNormalDiaryList(@RequestParam(required = false) String cursor,
//                                                @RequestParam(required = false, defaultValue = "10") int size){
//        return DiaryListQueryPagingResult.findNormalDiaryList(cursor,size);
//    }
//
//    @GetMapping("/angry-paging")
//    public DiaryListQueryPagingResult getAngryDiaryList(@RequestParam(required = false) String cursor,
//                                                   @RequestParam(required = false, defaultValue = "10") int size){
//        return DiaryListQueryPagingResult.findAngryDiaryList(cursor,size);
//    }

}
