package com.example.demo.user.usecase.outbound

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User
import com.example.demo.user.usecase.inbound.query.FindUserByEmailQuery

interface LoadUserPort {
    fun findByEmail(email: Email): User?;
}