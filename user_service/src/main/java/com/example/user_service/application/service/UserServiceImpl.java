package com.example.user_service.application.service;

import com.example.user_service.application.mapper.UserMapper;
import com.example.user_service.domain.model.User;
import com.example.user_service.domain.repository.UserRepository;
import com.example.user_service.domain.service.UserService;
import com.example.user_service.entity.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {
        UserEntity userEntity = UserMapper.INSTANCE.userModelToEntity(user);
        return UserMapper.INSTANCE.userEntityToModel(userRepository.save(userEntity));
    }

    @Override
    public User getUserById(Long userId) {
        UserEntity userEntity = userRepository.findById(userId).orElse(null);
        return UserMapper.INSTANCE.userEntityToModel(userEntity);
    }

    @Override
    public User updateUser(Long userId, User user) {
        user.setId(userId);
        UserEntity userEntity = UserMapper.INSTANCE.userModelToEntity(user);
        return UserMapper.INSTANCE.userEntityToModel(userRepository.save(userEntity));
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public List<User> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        return UserMapper.INSTANCE.userEntityListToModelList(userEntities);
    }

    @Override
    public User getUserByUsername(String username) {
        UserEntity userEntity = userRepository.findByUsername(username);
        return UserMapper.INSTANCE.userEntityToModel(userEntity);
    }

    @Override
    public User getUserByEmail(String email) {
        UserEntity userEntity = userRepository.findByEmail(email);
        return UserMapper.INSTANCE.userEntityToModel(userEntity);
    }

    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        UserEntity userEntity = userRepository.findByUsername(username);
        if (userEntity != null && userEntity.getPassword().equals(password)) {
            return UserMapper.INSTANCE.userEntityToModel(userEntity);
        }
        return null;
    }
}
