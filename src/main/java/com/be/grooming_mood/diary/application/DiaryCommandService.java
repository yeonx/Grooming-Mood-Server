package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.command.DiaryCreateCommand;
import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryRepository;
import com.be.grooming_mood.user.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class DiaryCommandService {
    private final DiaryRepository diaryRepository;

    @Transactional
    public long create(DiaryCreateCommand diaryCreateCommand, User user){
        Diary diary = Diary.builder()
                .user(user)
                .feeling(diaryCreateCommand.getFeeling())
                .diaryContent(diaryCreateCommand.getContent())
                .isPublic(diaryCreateCommand.getIsPublic())
                .build();
        diaryRepository.save(diary);
        return diary.getId();
    }
}
