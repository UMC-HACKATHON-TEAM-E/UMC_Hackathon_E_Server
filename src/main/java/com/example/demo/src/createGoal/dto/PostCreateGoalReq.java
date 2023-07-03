package com.example.demo.src.createGoal.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class PostCreateGoalReq {
    private String title;
    private Date startDate;
    private Date endDate;
    private int goalCount;
    private Long userId;
    private int period;
}
