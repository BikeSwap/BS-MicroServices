package com.example.user_service.user.domain.services;

import com.example.user_service.user.domain.model.commands.CreateUserCommand;

public interface UserCommandService {
    Long handle(CreateUserCommand createUserCommand);
}
