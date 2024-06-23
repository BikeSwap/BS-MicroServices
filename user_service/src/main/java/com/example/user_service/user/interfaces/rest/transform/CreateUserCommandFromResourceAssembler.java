package com.example.user_service.user.interfaces.rest.transform;

import com.example.user_service.user.domain.model.commands.CreateUserCommand;
import com.example.user_service.user.interfaces.rest.resource.CreateUserResource;

public class CreateUserCommandFromResourceAssembler {
    public static CreateUserCommand toCommandFromResource(CreateUserResource resource){
        return new CreateUserCommand(
                resource.name(),
                resource.lastName(),
                resource.firstName(),
                resource.email(),
                resource.password());
    }
}
