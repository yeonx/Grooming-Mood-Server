package com.be.grooming_mood.feeling.service;

import com.be.grooming_mood.exception.NotFoundException;
import com.be.grooming_mood.feeling.domain.FeelingHistory;
import com.be.grooming_mood.feeling.dto.FeelingHistoryCreateDto;
import com.be.grooming_mood.feeling.dto.FeelingHistoryInfo;
import com.be.grooming_mood.feeling.dto.FeelingHistoryInfoList;
import com.be.grooming_mood.feeling.dto.FeelingStatisticInfoList;
import com.be.grooming_mood.feeling.repository.FeelingHistoryQueryDao;
import com.be.grooming_mood.feeling.repository.FeelingHistoryRepository;
import com.be.grooming_mood.user.domain.User;
import com.be.grooming_mood.user.domain.UserRepository;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
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
    private final FeelingHistoryQueryDao feelingHistoryQueryDao;

    @Transactional(readOnly = true)
    public FeelingHistoryInfoList getFeelingHistoryList(Long userId){

        LocalDateTime start = YearMonth.now().atDay(1).atStartOfDay();
        LocalDateTime end = YearMonth.now().atEndOfMonth().atStartOfDay();

        return feelingHistoryQueryDao.findAllFeelingHistoryInThisMonth(start, end);
    }

    @Transactional(readOnly = true)
    public FeelingStatisticInfoList getFeelingInLastWeek(Long userId){

        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.add(Calendar.DATE, -7);
        cal2.add(Calendar.DATE, -7);

        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONTH);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        LocalDateTime mondayInLastWeek = cal1.getTime().toInstant() .atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime fridayInLastWeek = cal2.getTime().toInstant() .atZone(ZoneId.systemDefault()).toLocalDateTime();

        return feelingHistoryQueryDao.findAllFeelingStatisticsInLastWeek(userId, mondayInLastWeek, fridayInLastWeek);
    }


    @Transactional(readOnly = true)
    public FeelingStatisticInfoList getFeelingInThisWeek(Long userId){
        Calendar cal1 = Calendar.getInstance();
        Calendar cal2 = Calendar.getInstance();

        cal1.set(Calendar.DAY_OF_WEEK, Calendar.MONTH);
        cal2.set(Calendar.DAY_OF_WEEK, Calendar.FRIDAY);

        LocalDateTime mondayInThisWeek = cal1.getTime().toInstant() .atZone(ZoneId.systemDefault()).toLocalDateTime();
        LocalDateTime fridayInThisWeek = cal2.getTime().toInstant() .atZone(ZoneId.systemDefault()).toLocalDateTime();

        return feelingHistoryQueryDao.findAllFeelingStatisticsInThisWeek(userId, mondayInThisWeek, fridayInThisWeek);
    }

    @Transactional
    public String createFeelingHistory(FeelingHistoryCreateDto feelingHistoryCreateDto) {
        Optional<User> userCheck = userRepository.findById(feelingHistoryCreateDto.getUserId());

        User user = userCheck.orElseThrow(() ->
                new NotFoundException(USER_NOT_FOUND));

        FeelingHistory feelingHistory = FeelingHistory.builder()
                .user(user)
                .feeling(feelingHistoryCreateDto.getFeeling())
                .build();

        feelingHistoryRepository.save(feelingHistory);

        return "ok";
    }
}
