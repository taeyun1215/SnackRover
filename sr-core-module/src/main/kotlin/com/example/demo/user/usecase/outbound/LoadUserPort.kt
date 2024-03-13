package com.example.demo.user.usecase.outbound

import com.example.demo.user.domain.User
import com.example.user.Email

interface LoadUserPort {
    fun findByUserId(userId: Long): User
    fun findByEmail(email: Email): User?
}