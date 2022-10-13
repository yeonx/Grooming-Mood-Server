package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.command.DiaryCreateCommand;
import com.be.grooming_mood.diary.application.command.DiaryUpdateCommand;
import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryJpaInterfaceRepository;
import com.be.grooming_mood.diary.domain.DiaryRepository;
import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.be.grooming_mood.exception.ErrorCode.DIARY_NOT_FOUND;
import static com.be.grooming_mood.exception.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class DiaryCommandService {
    private final DiaryRepository diaryRepository;
    private final DiaryJpaInterfaceRepository diaryJpaInterfaceRepository;
    private final UserRepository userRepository;

    @Transactional
    public long create(Long userId, DiaryCreateCommand diaryCreateCommand){
        Optional<User> userCheck = userRepository.findById(userId);

        User user = userCheck.orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND));

        Diary diary = Diary.builder()
                .user(user)
                .feeling(diaryCreateCommand.getFeeling())
                .diaryContent(diaryCreateCommand.getContent())
                .isPublic(diaryCreateCommand.getIsPublic())
                .build();
        diaryRepository.save(diary);
        return diary.getId();
    }

    @Transactional
    public void update(Long diaryId, DiaryUpdateCommand diaryUpdateCommand){
        Optional<Diary> diaryCheck = diaryJpaInterfaceRepository.findById(diaryId);
        Diary diary = diaryCheck.orElseThrow(() ->
                new NotFoundException(DIARY_NOT_FOUND));
        diary.update(diaryUpdateCommand.getContent(),diaryUpdateCommand.getIsPublic());

    }

    @Transactional
    public void delete(Long diaryId){
        diaryJpaInterfaceRepository.deleteById(diaryId);
    }
}
