package com.example.demo.user.usecase.inbound.service

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User
import com.example.demo.user.domain.UserRole
import com.example.demo.user.usecase.inbound.command.RegisterUserCommand
import com.example.demo.user.usecase.outbound.SaveUserPort
import org.springframework.stereotype.Service

@Service
class RegisterUserService(private val saveUserPort: SaveUserPort) {

    fun registerUser(registerUserCommand: RegisterUserCommand) {
        val user = User(
            name = registerUserCommand.username,
            password = registerUserCommand.password,
            email = Email(registerUserCommand.email),
            userRole = UserRole.validationUserRole(registerUserCommand.userRole)
        )

        saveUserPort.saveUser(user)
    }
}