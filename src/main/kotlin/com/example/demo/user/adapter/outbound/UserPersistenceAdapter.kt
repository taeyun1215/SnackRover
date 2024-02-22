package com.example.demo.user.adapter.outbound

import com.example.demo.user.domain.Email
import com.example.demo.user.domain.User
import com.example.demo.user.infrastructure.UserRepository
import com.example.demo.user.usecase.inbound.query.FindUserByEmailQuery
import com.example.demo.user.usecase.outbound.LoadUserPort
import com.example.demo.user.usecase.outbound.SaveUserPort
import jakarta.transaction.Transactional
import org.springframework.stereotype.Component
import javax.swing.text.StyledEditorKit.FontFamilyAction

@Component
@Transactional
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : SaveUserPort, LoadUserPort {

    override fun saveUser(user: User) {
        userRepository.save(userMapper.mapToJpaEntity(user))
    }

    override fun findByUserId(userId: Long): User? {
        TODO("Not yet implemented")
    }

    override fun findByEmail(email: Email): User? {
        return userRepository.findByEmail(email.address)?.let { userJpaEntity ->
            userMapper.mapToDomainEntity(userJpaEntity)
        }
    }
}