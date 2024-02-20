package com.example.demo.user.infrastructure

import com.example.demo.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<UserJpaEntity, Long> {
    fun save(user: User)
    fun findByEmail(email: String): UserJpaEntity?
}