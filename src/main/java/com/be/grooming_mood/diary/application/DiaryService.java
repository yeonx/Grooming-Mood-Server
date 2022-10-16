package com.be.grooming_mood.diary.application;

import com.be.grooming_mood.diary.application.criteria.mydiary.MyDiaryListDto;
import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.be.grooming_mood.exception.ErrorCode.USER_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class DiaryService {
//    private final UserRepository userRepository;
//
//    @Transactional(readOnly = true)
//    public MyDiaryListDto MyDiaryListInfo(Long userId){
//        Optional<User> userCheck = userRepository.findById(userId);
//        User user = userCheck.orElseThrow(() ->
//                new NotFoundException(USER_NOT_FOUND));
//        return new MyDiaryListDto(user);
//    }
}
