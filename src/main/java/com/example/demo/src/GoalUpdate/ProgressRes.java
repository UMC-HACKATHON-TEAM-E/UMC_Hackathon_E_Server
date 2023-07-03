package com.example.demo.src.GoalUpdate;

import com.example.demo.src.Domain.Goal;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProgressRes {
    Goal goal;
    Double progress;

}
