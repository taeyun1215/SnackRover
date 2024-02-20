package com.example.demo.user.domain

data class User(
    val userId: Long? = null, // 기본값으로 null 설정,
    val name: String,
    val email: String,
    val password: String
)