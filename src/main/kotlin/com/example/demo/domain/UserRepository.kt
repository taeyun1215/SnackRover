package com.example.demo.domain

interface UserRepository {
    fun save(user: User): User
    fun findByEmail(email: String): User?
}