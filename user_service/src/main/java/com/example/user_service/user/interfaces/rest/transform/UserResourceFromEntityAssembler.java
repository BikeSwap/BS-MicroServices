package com.example.user_service.user.interfaces.rest.transform;

import com.example.user_service.user.domain.model.aggregates.User;
import com.example.user_service.user.interfaces.rest.resource.UserResource;

public class UserResourceFromEntityAssembler {
    public static UserResource toResourceFromEntity(User user){
        return new UserResource(
                user.getId(),
                user.getName(),
                user.getLastName(),
                user.getFirstName(),
                user.getEmail(),
                user.getPassword());
    }
}
