package com.example.demo.user.usecase.inbound.service

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserRepository
import com.example.demo.user.usecase.inbound.query.FindUserByEmailQuery
import com.example.demo.user.usecase.outbound.LoadUserPort
import jakarta.persistence.EntityNotFoundException
import org.springframework.stereotype.Service

@Service
class FindUserByEmailService(
    private val LoadUserPort: LoadUserPort
) {
    fun findUserByEmail(query: FindUserByEmailQuery): User? {
        val email = Email(address = query.email)

        return LoadUserPort.findByEmail(email)
            ?: throw EntityNotFoundException(
                "User with email ${email.address} not found"
            )
    }
}