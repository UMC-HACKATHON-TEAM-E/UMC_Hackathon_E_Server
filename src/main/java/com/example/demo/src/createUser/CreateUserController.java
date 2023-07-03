package com.example.demo.src.createUser;

import com.example.demo.src.Domain.User;
import com.example.demo.src.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/user")
public class CreateUserController {

    private final UserRepository userRepository;
    @GetMapping("/default")
    public void createUser(){
        User user1 = new User();
        user1.setEmail("user1@naver.com");
        user1.setId(Long.valueOf(1));
        user1.setName("user1");
        user1.setPassword("1234");
        userRepository.save(user1);

    }
}
