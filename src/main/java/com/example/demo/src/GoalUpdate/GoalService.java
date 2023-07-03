package com.example.demo.src.GoalUpdate;

import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.GoalRepository;
import com.example.demo.src.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class GoalService {

    private final UserRepository userRepository;
    private final GoalRepository goalRepository;

    @Transactional
    public Goal update(Long goalId){
        //User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        Goal goal = goalRepository.findById(goalId).orElseThrow(() -> new IllegalArgumentException("해당 목표가 존재하지 않습니다."));
        goal.update();
        return goalRepository.save(goal);
    }
}
