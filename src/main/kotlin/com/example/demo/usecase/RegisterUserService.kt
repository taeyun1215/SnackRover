package com.example.demo.usecase

import com.example.demo.domain.User
import com.example.demo.domain.UserRepository

class RegisterUser(private val userRepository: UserRepository) {
    fun execute(user: User): User {
        validate(user)
        return userRepository.save(user)
    }

    private fun validate(user: User) {
        // 여기에 입력 검증 로직 추가 (예: 이메일 형식 검증, 비밀번호 강도 검증 등)
    }
}