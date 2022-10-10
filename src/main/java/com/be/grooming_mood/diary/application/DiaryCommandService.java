package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.command.DiaryCreateCommand;
import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryRepository;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DiaryCommandService {
    private final DiaryRepository diaryRepository;
    private final UserRepository userRepository;

    @Transactional
    public long create(Long userId, DiaryCreateCommand diaryCreateCommand){
        Optional<User> userCheck = userRepository.findById(userId);

        User user = userCheck.orElseThrow(() ->
                new RuntimeException("유저를 찾을 수 없습니다."));

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
