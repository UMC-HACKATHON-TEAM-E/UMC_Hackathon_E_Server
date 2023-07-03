package com.example.demo.src.createGoal;

import com.example.demo.config.BaseException;
import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.GoalRepository;
import com.example.demo.src.Repository.UserRepository;
import com.example.demo.src.createGoal.dto.PostCreateGoalReq;
import com.example.demo.src.createGoal.dto.PostCreateGoalRes;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.config.BaseResponseStatus.*;

@Slf4j
@RequiredArgsConstructor
@Service
public class CreateGoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public PostCreateGoalRes createGoal(PostCreateGoalReq postCreateGoalReq) throws BaseException {
        Optional<User> optionalUser = Optional.empty();
        log.info("Optional user 생성");
        System.out.println("Optional user 생성");
        if(!(optionalUser = userRepository.findById(postCreateGoalReq.getUserId())).isPresent())
            throw new BaseException(POST_CREATE_GOAL_NOT_EXISTS_USER);
            log.info("Optional user true");
        System.out.println("Optional user 생성");

        try {
            System.out.println("1");
            Goal goal = new Goal();
            System.out.println("2");
            goal.createGoal(postCreateGoalReq.getTitle(), postCreateGoalReq.getStartDate(), postCreateGoalReq.getEndDate()
                            , postCreateGoalReq.getGoalCount(), optionalUser.get(), postCreateGoalReq.getPeriod());
            System.out.println(postCreateGoalReq.getTitle());
            System.out.println(goal.getTitle());
            goalRepository.save(goal);
            log.info("Optional user false");
            return new PostCreateGoalRes(goal.getTitle());
        }
        catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
