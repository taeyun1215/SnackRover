package com.example.demo.user.usecase.inbound.command

data class RegisterUserCommand(
    val name: String,
    val email: String,
    val password: String
)