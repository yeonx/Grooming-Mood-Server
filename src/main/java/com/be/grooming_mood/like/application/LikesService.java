package com.be.grooming_mood.like.application;

import com.be.grooming_mood.diary.domain.Diary;
import com.be.grooming_mood.diary.domain.DiaryJpaInterfaceRepository;
import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.like.infra.LikesRepository;
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
public class LikesService {
    private final LikesRepository likesRepository;
    private final UserRepository userRepository;
    private final DiaryJpaInterfaceRepository diaryJpaInterfaceRepository;

    @Transactional
    public Integer likes(Long diaryId, Long userId){
        Optional<User> userCheck = userRepository.findById(userId);
        User user = userCheck.orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND));

        likesRepository.likes(diaryId, user.getId());
        Optional<Diary> diaryCheck = diaryJpaInterfaceRepository.findById(diaryId);
        Diary diary = diaryCheck.orElseThrow(() ->
                new NotFoundException(DIARY_NOT_FOUND));
        return likesRepository.findAllByDiary(diary).size();
    }

    @Transactional
    public Integer unlikes(Long diaryId, Long userId){
        Optional<User> userCheck = userRepository.findById(userId);
        User user = userCheck.orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND));
        likesRepository.unLikes(diaryId, user.getId());
        Optional<Diary> diaryCheck = diaryJpaInterfaceRepository.findById(diaryId);
        Diary diary = diaryCheck.orElseThrow(() ->
                new NotFoundException(DIARY_NOT_FOUND));
        return likesRepository.findAllByDiary(diary).size();
    }
}
