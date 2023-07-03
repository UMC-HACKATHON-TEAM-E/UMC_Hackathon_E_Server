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
@RequestMapping("/goal")
@RequiredArgsConstructor
public class GoalController {

    private final GoalService goalService;
    @GetMapping("/{goalId}")
    public BaseResponse<Goal> update(@PathVariable("goalId") Long goalId){
        Goal goal = goalService.update(goalId);;
        return new BaseResponse<>(goal);
    }
}
