package com.example.demo.user.adapter.outbound

import com.example.demo.user.domain.User
import com.example.user.UserJpaEntity
import org.springframework.stereotype.Component

@Component
class UserMapper {
    fun mapToDomainEntity(userJpaEntity: UserJpaEntity): User = User(
        username = userJpaEntity.username,
        password = userJpaEntity.password,
        email = userJpaEntity.email,
        userRole = userJpaEntity.userRole
    )

    fun mapToJpaEntity(user: User): UserJpaEntity = UserJpaEntity(
        username = user.username,
        password = user.password,
        email = user.email,
        userRole = user.userRole
    )
}