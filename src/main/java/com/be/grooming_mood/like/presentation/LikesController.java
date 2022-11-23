package com.be.grooming_mood.like.presentation;

import com.be.grooming_mood.like.application.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController

public class LikesController {
    private final LikesService likesService;

    @CrossOrigin(origins = "*")
    @PostMapping("/feed-diary/{diaryId}/like")
    public void likes(@PathVariable("diaryId") long diaryId,
                      @RequestBody long userId){
        likesService.likes(diaryId,userId);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/feed-diary/{diaryId}/unlike")
    public void unlikes(@PathVariable("diaryId") long diaryId,long userId){
        likesService.unlikes(diaryId,userId);
    }

}
