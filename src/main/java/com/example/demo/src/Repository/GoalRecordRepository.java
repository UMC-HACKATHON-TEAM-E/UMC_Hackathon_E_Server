package com.example.demo.src.Repository;

import com.example.demo.src.Domain.GoalRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GoalRecordRepository extends JpaRepository<GoalRecord,Long> {
}
