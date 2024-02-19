package com.example.demo.adapter

import com.example.demo.domain.User
import com.example.demo.usecase.RegisterUser
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/users")
class UserController(private val registerUser: RegisterUser) {

    @PostMapping("/register")
    fun registerUser(@RequestBody request: RegisterUserRequest): ResponseEntity<UserResponse> {
        val user = User(name = request.name, email = request.email, password = request.password)
        val registeredUser = registerUser.execute(user)
        return ResponseEntity.ok(UserResponse(registeredUser))
    }
}

data class RegisterUserRequest(val name: String, val email: String, val password: String)

data class UserResponse(val id: Long?, val name: String, val email: String)