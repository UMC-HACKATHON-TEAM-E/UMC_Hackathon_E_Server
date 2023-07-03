package com.example.demo.src.Domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GoalRecord {
    @Id
    @Column(name = "goal_record_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long goalRecordId;
    @ManyToOne
    @JoinColumn(name = "goal_id")
    private Goal goal;
    @Column(name = "record_date")
    private Date recordDate;
    public GoalRecord createGoalRecord(Goal goal, Date recordDate) {
        this.goal = goal;
        this.recordDate = recordDate;
        return this;
    }
}
