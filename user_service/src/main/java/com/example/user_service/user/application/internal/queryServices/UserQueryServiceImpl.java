package com.example.user_service.user.application.internal.queryServices;

import com.example.user_service.infraestructure.persistence.jpa.repositories.UserRepository;
import com.example.user_service.user.domain.model.aggregates.User;
import com.example.user_service.user.domain.model.querys.GetUserById;
import com.example.user_service.user.domain.services.UserQueryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserQueryServiceImpl implements UserQueryService {
    private final UserRepository userRepository;
    private UserQueryServiceImpl(UserRepository userRepository){this.userRepository=userRepository;}

    @Override
    public Optional<User>handle(GetUserById userById){return userRepository.findById(userById.userId());}


    @Override
    public List<User>getAllUsers(){return userRepository.findAll();}
}
