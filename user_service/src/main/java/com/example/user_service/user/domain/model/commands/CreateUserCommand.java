package com.example.user_service.user.domain.model.commands;

public record CreateUserCommand(
    String name,
    String lastName,
    String firstName,
    String email,
    String password
) {
}
