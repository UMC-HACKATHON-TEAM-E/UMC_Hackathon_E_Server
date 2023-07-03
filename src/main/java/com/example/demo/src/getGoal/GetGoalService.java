package com.example.demo.src.getGoal;

import com.example.demo.config.BaseException;
import com.example.demo.config.BaseResponseStatus;
import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.GoalRepository;
import com.example.demo.src.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetGoalService {
    private final GoalRepository goalRepository;
    private final UserRepository userRepository;

    public List<Goal> getGoal(Long userId) throws BaseException {
        User user = userRepository.findById(userId)
                .orElseThrow(
                        () -> new BaseException(BaseResponseStatus.USERS_EMPTY_USER_ID)
                );
        List<Goal> goals = goalRepository.findByUser(user);
        for (int i = 0; i < goals.size(); i++){
            System.out.println(goals.get(i));
        }
        return goals;
    }



}
