package com.example.demo.user.adapter.inbound.web

import com.example.demo.user.adapter.inbound.dto.RegisterUserRequest
import com.example.demo.user.adapter.inbound.dto.RegisterUserResponse
import com.example.demo.user.usecase.inbound.command.RegisterUserCommand
import com.example.demo.user.usecase.inbound.service.RegisterUserService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class RegisterUserController(private val registerUserService: RegisterUserService) {

    @PostMapping("/register")
    fun registerUser(@RequestBody request: RegisterUserRequest): ResponseEntity<RegisterUserResponse> {
        val registerUserCommand = RegisterUserCommand(
            username = request.username,
            password = request.password,
            email = request.email
        )

        registerUserService.registerUser(registerUserCommand)
        return ResponseEntity.ok(RegisterUserResponse("회원가입이 완료되었습니다."))
    }
}


