package com.example.demo.src.createGoalRecord;


import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.GoalRecord;
import com.example.demo.src.Repository.GoalRecordRepository;
import com.example.demo.src.Repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

import static com.example.demo.config.BaseResponseStatus.DATABASE_ERROR;
import static com.example.demo.config.BaseResponseStatus.POST_CREATE_GOAL_RECORD_NOT_EXISTS_USER;

@RequiredArgsConstructor
@Service
public class CreateGoalRecordService {
    private final GoalRecordRepository goalRecordRepository;
    private final GoalRepository goalRepository;

    public GoalRecord createGoalRecord(Long goalId) throws BaseException {
        Date date = new Date();
        LocalDateTime now = LocalDateTime.now();
        Optional<Goal> optionalGoal = Optional.empty();
        if(!(optionalGoal = goalRepository.findById(goalId)).isPresent())
            throw new BaseException(POST_CREATE_GOAL_RECORD_NOT_EXISTS_USER);
        try {
            GoalRecord goalRecord = new GoalRecord();
            goalRecord.createGoalRecord(optionalGoal.get(), date);
            goalRecordRepository.save(goalRecord);
            return goalRecord;
        }
        catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
