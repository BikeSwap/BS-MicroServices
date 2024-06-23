package com.example.user_service.user.domain.services;

import com.example.user_service.user.domain.model.aggregates.User;
import com.example.user_service.user.domain.model.querys.GetUserById;

import java.util.List;
import java.util.Optional;

public interface UserQueryService {
    Optional<User> handle(GetUserById userById);
    List<User>getAllUsers();
}
