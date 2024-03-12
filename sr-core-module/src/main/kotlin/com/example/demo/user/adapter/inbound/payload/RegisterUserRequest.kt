package com.example.demo.user.adapter.inbound.payload

data class RegisterUserRequest(
    val username: String,
    val email: String,
    val password: String,
    val userRole: String
)
