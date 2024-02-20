package com.example.demo.user.adapter.inbound.dto

data class RegisterUserRequest(
    val username: String,
    val email: String,
    val password: String
)
