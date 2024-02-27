package com.example.demo.user.usecase.outbound

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User

interface LoadUserPort {
    fun findByUserId(userId: Long): User
    fun findByEmail(email: Email): User?
}