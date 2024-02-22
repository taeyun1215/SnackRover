package com.example.demo.user.usecase.outbound

import com.example.demo.user.domain.User

interface SaveUserPort {
    fun saveUser(user: User)
}