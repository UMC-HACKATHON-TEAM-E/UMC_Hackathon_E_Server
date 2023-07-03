package com.example.demo.src.GoalUpdate;

import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.GoalRepository;
import com.example.demo.src.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@RequiredArgsConstructor
@Service
public class GoalService {

    private final UserRepository userRepository;
    private final GoalRepository goalRepository;

    @Transactional
    public Goal update(Long goalId){
        //User user = userRepository.findById(userId).orElseThrow(() -> new IllegalArgumentException("해당 유저가 존재하지 않습니다."));
        Goal goal = goalRepository.findByGoalId(goalId);
        goal.update();
        return goalRepository.save(goal);
    }
      public Goal read(Long goalId){
        Goal goal = goalRepository.findByGoalId(goalId);
        return goal;
    }

    public Double progress(Long goalId) throws ParseException {
        Goal goal = goalRepository.findByGoalId(goalId);
        Date createGoal =goal.getStartDate();
        LocalDate now = LocalDate.now();

        Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(createGoal));
        Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(now));
        long diffSec = (format2.getTime() - format1.getTime()) / 1000; //초 차이
        long diffDays = diffSec / (24*60*60);
        //System.out.println(diffDays + "일 차이");
        double x = goal.getCount() /(double) diffDays;
        System.out.println(diffDays);
        System.out.println(x);


        Date format3 = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(goal.getEndDate()));
        Date format4 = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(goal.getStartDate()));
        long diffSe = (format3.getTime() - format4.getTime()) / 1000; //초 차이
        long diffDay = diffSe / (24*60*60);
        System.out.println(diffDay);
        double y = goal.getGoalCount()/(double)diffDay;

        System.out.println(y);

        double ans =(x/y) * 100;

        return ans;

    }
}
