package com.be.grooming_mood.diary.presentation;

import com.be.grooming_mood.diary.application.DiaryQueryService;
import com.be.grooming_mood.diary.application.criteria.DiaryDetailInfoCriteria;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryPagingResult;
import com.be.grooming_mood.diary.application.criteria.DiaryListQueryResult;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/feed-diary")
public class FeedDiaryController {
    private final DiaryQueryService diaryQueryService;

    @CrossOrigin(origins = "*")
    @ApiOperation(value ="전체 일기 조회")
    @GetMapping("/all-paging")
    public DiaryListQueryPagingResult getAllDiaryList(@RequestParam(required = false) String cursor,
                                                      @RequestParam(required = false, defaultValue = "3") int size){
        return diaryQueryService.findAllDiaryList(cursor,size);
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value ="행복 일기 조회")
    @GetMapping("/happy-paging")
    public DiaryListQueryPagingResult getHappyDiaryList(@RequestParam(required = false) String cursor,
                                                        @RequestParam(required = false, defaultValue = "3") int size){
        return diaryQueryService.findHappyDiaryList(cursor,size);
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value ="슬픈 일기 조회")
    @GetMapping("/sad-paging")
    public DiaryListQueryPagingResult getSadDiaryList(@RequestParam(required = false) String cursor,
                                                      @RequestParam(required = false, defaultValue = "3") int size){
        return diaryQueryService.findSadDiaryList(cursor,size);
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value ="평범 일기 조회")
    @GetMapping("/normal-paging")
    public DiaryListQueryPagingResult getNormalDiaryList(@RequestParam(required = false) String cursor,
                                                         @RequestParam(required = false, defaultValue = "3") int size){
        return diaryQueryService.findNormalDiaryList(cursor,size);
    }

    @CrossOrigin(origins = "*")
    @ApiOperation(value ="화남 일기 조회")
    @GetMapping("/angry-paging")
    public DiaryListQueryPagingResult getAngryDiaryList(@RequestParam(required = false) String cursor,
                                                        @RequestParam(required = false, defaultValue = "5") int size){
        return diaryQueryService.findAngryDiaryList(cursor,size);
    }

    /**
     * 스크롤
     */
//    @ApiOperation(value ="전체 일기 조회")
//    @GetMapping("/all")
//    public DiaryListQueryResult getAllDiaryList(){
//        return diaryQueryService.findAllDiaryList();
//    }
//    @ApiOperation(value ="행복 일기 조회")
//    @GetMapping("/happy")
//    public DiaryListQueryResult getHappyDiaryList(){
//        return diaryQueryService.findHappyDiaryList();
//    }
//    @ApiOperation(value ="슬픔 일기 조회")
//    @GetMapping("/sad")
//    public DiaryListQueryResult getSadDiaryList(){
//        return diaryQueryService.findSadDiaryList();
//    }
//
//    @ApiOperation(value ="평범 일기 조회")
//    @GetMapping("/normal")
//    public DiaryListQueryResult getNormalDiaryList(){
//        return diaryQueryService.findNormalDiaryList();
//    }
//
//    @ApiOperation(value ="화남 일기 조회")
//    @GetMapping("/angry")
//    public DiaryListQueryResult getAngryDiaryList(){
//        return diaryQueryService.findAngryDiaryList();
//    }

}
