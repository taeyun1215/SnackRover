package com.example.demo.user.adapter.outbound

import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserJpaEntity

class UserMapper {
    fun mapToDomainEntity(userJpaEntity: UserJpaEntity?): User? {
        return userJpaEntity?.let {
            User(
                userId = it.id,
                name = it.name,
                password = it.password,
                email = it.email
            )
        }
    }

    fun mapToJpaEntity(user: User): UserJpaEntity = UserJpaEntity(
        id = user.userId,
        name = user.name,
        password = user.password,
        email = user.email
    )
}