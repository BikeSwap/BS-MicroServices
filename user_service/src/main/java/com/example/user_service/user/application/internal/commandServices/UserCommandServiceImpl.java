package com.example.user_service.user.application.internal.commandServices;

import com.example.user_service.infraestructure.persistence.jpa.repositories.UserRepository;
import com.example.user_service.user.domain.model.aggregates.User;
import com.example.user_service.user.domain.model.commands.CreateUserCommand;
import com.example.user_service.user.domain.services.UserCommandService;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {
    private final UserRepository userRepository;
    public  UserCommandServiceImpl(UserRepository userRepository){
        this.userRepository=userRepository;}
    @Override
    public Long handle(CreateUserCommand createUserCommand){
        var user=new User(createUserCommand.name(),
                createUserCommand.lastName(),
                createUserCommand.firstName(),
                createUserCommand.email(),
                createUserCommand.password());
        userRepository.save(user);
        return user.getId();
    }
}
