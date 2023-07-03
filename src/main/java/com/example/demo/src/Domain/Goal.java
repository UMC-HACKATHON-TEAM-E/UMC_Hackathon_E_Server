package com.example.demo.src.Domain;

import javax.persistence.*;
import java.util.Date;

public class Goal {

    @Id
    @Column(name = "goal_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goalId;

    @Column(name = "title")
    private String title;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "goal_count")
    private int goalCount;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "period")
    private int period;

    @Column(name = "count")
    private int count;


}