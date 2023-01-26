package com.study.kotlin.user.adapter.output.mapper

import com.study.kotlin.common.Mapper
import com.study.kotlin.user.adapter.output.entity.EUser
import com.study.kotlin.user.application.command.input.RegisterUserCommand
import com.study.kotlin.user.domain.User

@Mapper
class UserMapper {

    fun mapToEntity(registerUserCommand: RegisterUserCommand): EUser =
        EUser(name = registerUserCommand.name, age = registerUserCommand.age)

    fun mapToEntity(user: User): EUser = EUser(name = user.name, age = user.age)

    fun mapToDomain(user: EUser): User {
        return User(id = user.id, name = user.name, age = user.age)
    }
}
