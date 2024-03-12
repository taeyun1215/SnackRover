package com.example.demo.user.adapter.outbound

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserRepository
import com.example.demo.user.usecase.outbound.LoadUserPort
import com.example.demo.user.usecase.outbound.SaveUserPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component

@Component
@Transactional
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : SaveUserPort, LoadUserPort {

    override fun saveUser(user: User) {
        userRepository.save(userMapper.mapToJpaEntity(user))
    }

    override fun findByUserId(userId: Long): User {
        return userMapper.mapToDomainEntity(userRepository.findById(userId)
            .orElseThrow {
                NoSuchElementException("User with foodTruckId $userId not found")
            })
    }

    override fun findByEmail(email: Email): User? {
        return userRepository.findByEmail(email.address)?.let { userJpaEntity ->
            userMapper.mapToDomainEntity(userJpaEntity)
        }
    }
}