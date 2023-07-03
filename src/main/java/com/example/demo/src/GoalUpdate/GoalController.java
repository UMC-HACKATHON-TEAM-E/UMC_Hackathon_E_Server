package com.example.demo.src.GoalUpdate;


import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.Domain.Goal;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    @GetMapping("/{userId}/{goalId}")
    public BaseResponse<Goal> update(@PathVariable("userId") Long userId, @PathVariable("goalId") Long goalId){
        Goal goal = goalService.update(userId, goalId);;
        return new BaseResponse<>(goal);
    }
}
