package com.example.demo.src.createGoal;

import com.example.demo.src.Repository.GoalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class CreateGoalService {
    private final GoalRepository goalRepository;
}
