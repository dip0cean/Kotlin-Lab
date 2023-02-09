package com.study.kotlin.user.adapter.output.persistence

import com.study.kotlin.common.PersistenceAdapter
import com.study.kotlin.repository.UserRepository
import com.study.kotlin.user.adapter.output.mapper.UserMapper
import com.study.kotlin.user.application.command.input.RegisterUserCommand
import com.study.kotlin.user.application.port.input.RegisterUserPort
import com.study.kotlin.user.application.port.input.UpdateUserPort
import com.study.kotlin.user.application.port.output.GetUserPort
import com.study.kotlin.user.domain.User

@PersistenceAdapter
class UserPersistenceAdapter(
    private val userRepository: UserRepository,
    private val userMapper: UserMapper
) : RegisterUserPort,
    GetUserPort,
    UpdateUserPort {

    /**
     * 신규 유저 등록
     */
    override fun registerUser(registerUserCommand: RegisterUserCommand) {
        val user = userMapper.mapToEntity(registerUserCommand)
        userRepository.save(user)
    }

    /**
     * 모든 유저 조회
     */
    override fun getAllUser(): List<User> = userRepository.findAll()
        .map { user -> userMapper.mapToDomain(user) }

    override fun getUser(id: Long): User = userRepository.findById(id)
        .orElseThrow()
        .let { user -> userMapper.mapToDomain(user) }

    override fun updateUser(user: User) {
        userRepository.save(userMapper.mapToEntity(user))
    }
}
