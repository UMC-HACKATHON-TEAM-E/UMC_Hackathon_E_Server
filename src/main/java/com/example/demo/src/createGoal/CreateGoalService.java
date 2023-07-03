package com.example.demo.src.createGoal;

import com.example.demo.config.BaseException;
import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.GoalRepository;
import com.example.demo.src.Repository.UserRepository;
import com.example.demo.src.createGoal.dto.PostCreateGoalReq;
import com.example.demo.src.createGoal.dto.PostCreateGoalRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.example.demo.config.BaseResponseStatus.*;

@RequiredArgsConstructor
@Service
public class CreateGoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public PostCreateGoalRes createGoal(PostCreateGoalReq postCreateGoalReq) throws BaseException {
        Optional<User> optionalUser = Optional.empty();
        if(!(optionalUser = userRepository.findById(postCreateGoalReq.getUserId())).isPresent())
            throw new BaseException(POST_CREATE_GOAL_NOT_EXISTS_USER);
        try {
            Goal goal = new Goal();
            goal.createGoal(postCreateGoalReq.getTitle(), postCreateGoalReq.getStartDate(), postCreateGoalReq.getEndDate()
                            , postCreateGoalReq.getGoalCount(), optionalUser.get(), postCreateGoalReq.getPeriod());
            goalRepository.save(goal);
            return new PostCreateGoalRes(goal.getTitle());
        }
        catch (Exception e) {
            throw new BaseException(DATABASE_ERROR);
        }
    }
}
