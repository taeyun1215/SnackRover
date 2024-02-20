package com.example.demo.user.adapter.inbound.web

import com.example.demo.user.adapter.inbound.dto.RegisterUserRequest
import com.example.demo.user.adapter.inbound.dto.RegisterUserRespone
import com.example.demo.user.usecase.inbound.command.RegisterUserCommand
import com.example.demo.user.usecase.inbound.service.RegisterUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class RegisterUserController(private val registerUser: RegisterUser) {

    @PostMapping("/register")
    fun registerUser(@RequestBody request: RegisterUserRequest): ResponseEntity<RegisterUserRespone> {
        val registerUserCommand = RegisterUserCommand(
            name = request.name,
            email = request.email,
            password = request.password
        )

        registerUser.register(registerUserCommand)
        return ResponseEntity.ok(RegisterUserRespone("회원가입이 완료되었습니다."))
    }
}


