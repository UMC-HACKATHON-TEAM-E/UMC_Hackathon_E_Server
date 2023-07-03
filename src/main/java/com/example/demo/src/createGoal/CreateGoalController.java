package com.example.demo.src.createGoal;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponse;
import com.example.demo.src.createGoal.dto.PostCreateGoalReq;
import com.example.demo.src.createGoal.dto.PostCreateGoalRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/goal")
public class CreateGoalController {
    private final CreateGoalService createGoalService;
    @PostMapping("")
    public BaseResponse<PostCreateGoalRes> createGoal(@RequestBody PostCreateGoalReq postCreateGoalReq) {
        try {
            log.info("createGoal 실행");
            PostCreateGoalRes res = createGoalService.createGoal(postCreateGoalReq);
            return new BaseResponse<>(res);
        }
        catch (BaseException e) {
            return new BaseResponse<>(e.getStatus());
        }
    }
}
