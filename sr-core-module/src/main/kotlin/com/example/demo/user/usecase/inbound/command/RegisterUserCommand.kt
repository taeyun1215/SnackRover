package com.example.demo.user.usecase.inbound.command

data class RegisterUserCommand(
    val username: String,
    val password: String,
    val email: String,
    val userRole: String
)