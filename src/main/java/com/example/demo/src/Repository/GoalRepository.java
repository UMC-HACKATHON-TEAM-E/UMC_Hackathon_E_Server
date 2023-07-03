package com.example.demo.src.Repository;

import com.example.demo.src.Domain.Goal;
import com.example.demo.src.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoalRepository extends JpaRepository<Goal, Long> {
    List<Goal> findByUser(User user);
}
