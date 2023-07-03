package com.example.demo.src.createGoal;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/goal")
public class CreateGoalController {
    private final CreateGoalService createGoalService;
}
