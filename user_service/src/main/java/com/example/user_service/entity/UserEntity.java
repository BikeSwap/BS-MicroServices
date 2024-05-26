package com.example.user_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name="users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="username", nullable = false, length = 16)
    private String username;

    @Column(name="email", nullable = false, length = 16)
    private String email;

    @Column(name="password", nullable = false, length = 255)
    private String password;

    @Column(name="first_name", nullable = false, length = 12)
    private String firstName;

    @Column(name="last_name", nullable = false, length = 12)
    private String lastName;
}
