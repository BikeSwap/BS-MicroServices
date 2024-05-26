package com.example.user_service.domain.service;

import com.example.user_service.domain.model.User;

import java.util.List;

public interface UserService {
    public abstract User createUser(User user);
    public abstract User getUserById(Long user_id);
    public abstract User updateUser(Long userId, User user);
    public abstract void deleteUser(Long user_id);
    public abstract List<User> getAllUsers();
    public abstract User getUserByUsername(String username);
    public abstract User getUserByEmail(String email);
    public abstract User getUserByUsernameAndPassword(String username, String password);
}
