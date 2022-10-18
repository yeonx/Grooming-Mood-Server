package com.be.grooming_mood.reaction.controller;


import com.be.grooming_mood.oauth.LoginUser;
import com.be.grooming_mood.reaction.dto.ReactionDto;
import com.be.grooming_mood.reaction.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
public class ReactionController {

    private final ReactionService reactionService;

//    @PostMapping("/reaction/{diaryId}")
//    public void createReaction(
//            @LoginUser SessionUser user,
//            @PathVariable("diaryId") Long diaryId,
//            ReactionDto reactionDto) {
//
//        reactionService.createReaction(user.getId(), diaryId, reactionDto);
//    }

    @DeleteMapping("/reaction/")
    public void cancelReaction(@Valid ReactionDto reactionDto) {

        reactionService.deleteReaction(reactionDto.getUserId(), reactionDto.getDiaryId(), reactionDto.getReaction());
    }

}
