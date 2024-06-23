package com.example.user_service.user.interfaces.rest.resource;

public record CreateUserResource(
        String name,
        String lastName,
        String firstName,
        String email,
        String password
){
}
