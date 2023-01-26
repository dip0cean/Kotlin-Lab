package com.study.kotlin.user.application.service

import com.study.kotlin.common.UseCase
import com.study.kotlin.user.application.command.input.RegisterUserCommand
import com.study.kotlin.user.application.command.input.UpdateUserCommand
import com.study.kotlin.user.application.port.input.RegisterUserPort
import com.study.kotlin.user.application.port.input.UpdateUserPort
import com.study.kotlin.user.application.port.output.GetUserPort
import com.study.kotlin.user.application.useCase.input.RegisterUserUseCase
import com.study.kotlin.user.application.useCase.input.UpdateUserUseCase
import com.study.kotlin.user.application.useCase.output.GetAllUserUseCase
import com.study.kotlin.user.domain.User
import org.springframework.transaction.annotation.Transactional

@UseCase
open class UserService(
    private val registerUserPort: RegisterUserPort,
    private val getUserPort: GetUserPort,
    private val updateUserPort: UpdateUserPort
) : RegisterUserUseCase,
    GetAllUserUseCase,
    UpdateUserUseCase {

    /**
     * 신규 유저 등록
     */
    @Transactional
    override fun registerUser(registerUserCommand: RegisterUserCommand) {
        registerUserPort.registerUser(registerUserCommand)
    }

    /**
     * 모든 유저 조회
     */
    @Transactional(readOnly = true)
    override fun getAllUser(): List<User> = getUserPort.getAllUser()

    /**
     * 유저 정보 수정
     */
    @Transactional
    override fun updateUser(updateUserCommand: UpdateUserCommand) {
        val user = getUserPort.getUser(updateUserCommand.id)
        user.update(updateUserCommand.name, updateUserCommand.age)
        updateUserPort.updateUser(user)
    }
}
