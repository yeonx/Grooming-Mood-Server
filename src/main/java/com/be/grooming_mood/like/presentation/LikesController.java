package com.be.grooming_mood.like.presentation;

import com.be.grooming_mood.like.application.LikesService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

public class LikesController {
    private final LikesService likesService;

    @PutMapping("/feed-diary/{diaryId}/like")
    public void likes(@PathVariable("diaryId") long diaryId,long userId){
        likesService.likes(diaryId,userId);
    }

    @DeleteMapping("/feed-diary/{diaryId}/unlike")
    public void unlikes(@PathVariable("diaryId") long diaryId,long userId){
        likesService.unlikes(diaryId,userId);
    }

}
