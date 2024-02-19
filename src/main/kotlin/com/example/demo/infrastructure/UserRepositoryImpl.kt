package com.example.demo.infrastructure

import com.example.demo.domain.User
import com.example.demo.domain.UserRepository
import org.springframework.stereotype.Repository

@Repository
class UserRepositoryImpl : UserRepository {
    override fun save(user: User): User {
        // 데이터베이스에 사용자 저장 로직 구현
        return user
    }

    override fun findByEmail(email: String): User? {
        // 이메일로 사용자 조회 로직 구현
        return null
    }
}