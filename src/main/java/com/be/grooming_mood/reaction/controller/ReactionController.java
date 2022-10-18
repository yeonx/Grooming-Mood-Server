package com.be.grooming_mood.reaction.controller;


import com.be.grooming_mood.oauth.LoginUser;
import com.be.grooming_mood.reaction.dto.ReactionDto;
import com.be.grooming_mood.reaction.service.ReactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reaction")
public class ReactionController {

    private final ReactionService reactionService;

    @PostMapping("")
    public void createReaction(@Valid @RequestBody ReactionDto reactionDto) {

        reactionService.createReaction(
                reactionDto.getUserId(),
                reactionDto.getDiaryId(),
                reactionDto.getReaction());
    }

    @DeleteMapping("")
    public void cancelReaction(@Valid @RequestBody ReactionDto reactionDto) {

        reactionService.deleteReaction(
                reactionDto.getUserId(),
                reactionDto.getDiaryId(),
                reactionDto.getReaction());
    }

}
