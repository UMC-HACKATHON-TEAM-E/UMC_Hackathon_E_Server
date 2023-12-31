package com.example.demo.src.Domain;


import lombok.*;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")

//@DynamicInsert
public class User {
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false, length = 40)
    private String email;

    @Column(nullable = false, length = 16)
    private String password;

    @Column(unique = true, nullable = false, length = 10)
    private String name;
}
