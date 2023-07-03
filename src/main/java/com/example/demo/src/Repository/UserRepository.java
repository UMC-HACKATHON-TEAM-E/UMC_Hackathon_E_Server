package com.example.demo.src.Repository;

import com.example.demo.src.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByUserId(Long userId);
}
