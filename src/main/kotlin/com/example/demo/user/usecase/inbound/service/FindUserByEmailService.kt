package com.example.demo.user.usecase.inbound.service

import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserRepository
import com.example.demo.user.usecase.inbound.query.FindUserByEmailQuery
import org.springframework.stereotype.Service

@Service
class FindUserByEmailService(private val userRepository: UserRepository) {
    fun handle(query: FindUserByEmailQuery): User? {
        return userRepository.findByEmail(query.email)
    }

    fun avb() {

    }
}