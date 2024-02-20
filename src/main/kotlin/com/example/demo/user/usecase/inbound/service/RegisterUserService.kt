package com.example.demo.user.usecase.inbound.service

import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserRepository
import com.example.demo.user.usecase.inbound.command.RegisterUserCommand
import org.springframework.stereotype.Service

@Service
class RegisterUser(private val userRepository: UserRepository) {
    fun register(registerUserCommand: RegisterUserCommand) {
        val user = User(
            name = registerUserCommand.name,
            email = registerUserCommand.email,
            password = registerUserCommand.password
        )

        validate(user)
        userRepository.save(user)
    }

    private fun validate(user: User) {
        // 이메일 형식 검증
        if (!user.email.matches(Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}"))) {
            throw IllegalArgumentException("Invalid email format")
        }

        // 비밀번호 형식 검증
        if (!user.password.matches(Regex("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"))) {
            throw IllegalArgumentException("Password must be at least 8 characters long and include a mix of upper and lower case letters, numbers, and special characters")
        }
    }
}