package com.be.grooming_mood.feeling.service;

import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.feeling.domain.FeelingHistory;
import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import com.be.grooming_mood.feeling.repository.FeelingHistoryRepository;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.List;
import java.util.Optional;

import static com.be.grooming_mood.exception.ErrorCode.USER_NOT_FOUND;

@RequiredArgsConstructor
@Service
public class FeelingHistoryService {

    private final FeelingHistoryRepository feelingHistoryRepository;
    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<FeelingHistory> getFeelingHistoryList(Long userId){

        LocalDateTime start = YearMonth.now().atDay(1).atStartOfDay();
        LocalDateTime end = YearMonth.now().atEndOfMonth().atStartOfDay();

        return feelingHistoryRepository.findAllByCreatedDateBetween(start, end);
    }

    @Transactional
    public String createFeelingHistory(FeelingHistoryCreateDto feelingHistoryCreateDto) {
        Optional<User> userCheck = userRepository.findById(feelingHistoryCreateDto.getUserId());

        User user = userCheck.orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND));

        FeelingHistory feelingHistory = FeelingHistory.builder()
                .user(user)
                .feeling(feelingHistoryCreateDto.getFeeling())
                .createdDate(LocalDateTime.now())
                .build();

        feelingHistoryRepository.save(feelingHistory);

        return "ok";
    }
}
