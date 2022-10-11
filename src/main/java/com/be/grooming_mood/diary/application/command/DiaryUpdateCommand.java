package com.be.grooming_mood.diary.application.command;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
@Getter
public class DiaryUpdateCommand {
    private String content;
    private Boolean isPublic;
}
