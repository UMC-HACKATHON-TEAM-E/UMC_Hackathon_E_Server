package com.example.demo.src.createGoalRecord;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.Domain.GoalRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/goalRecord")
public class CreateGoalRecordController {
    private final CreateGoalRecordService createGoalRecordService;
    @PostMapping("/{goalId}")
    public BaseResponse<GoalRecord> createGoalRecord(@PathVariable(value="goalId") Long goalId) {
        try {
            return new BaseResponse<>(createGoalRecordService.createGoalRecord(goalId));
        }
        catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
