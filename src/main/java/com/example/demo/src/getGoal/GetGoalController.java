package com.example.demo.src.getGoal;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.Domain.Goal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/goal")
public class GetGoalController {
    private final GetGoalService getGoalService;

    @GetMapping("/getGoal/{userId}")
    BaseResponse<List<Goal>> getGoal(@PathVariable("userId") Long userId) throws BaseException {
        List<Goal> goals = getGoalService.getGoal(userId);
        return new BaseResponse<List<Goal>>(goals);
    }




}
