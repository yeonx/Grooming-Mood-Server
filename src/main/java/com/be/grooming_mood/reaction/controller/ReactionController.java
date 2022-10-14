package com.be.grooming_mood.reaction.controller;


import com.be.grooming_mood.reaction.dto.ReactionDto;
import com.be.grooming_mood.reaction.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("/reaction/{diaryId}")
    public void createReaction(@PathVariable("diaryId") Long diaryId, ReactionDto reactionDto) {
        reactionService.createReaction(1L, diaryId, reactionDto);
    }

    @DeleteMapping("/reaction/{diaryId}")
    public void cancelReaction(@PathVariable("diaryId") Long diaryId, ReactionDto reactionDto) {
        reactionService.deleteReaction(1L, diaryId, reactionDto);
    }

}
