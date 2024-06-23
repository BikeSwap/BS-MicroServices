package com.example.user_service.infraestructure.persistence.jpa.repositories;

import com.example.user_service.user.domain.model.aggregates.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findById(Long id);
}
