package com.study.kotlin.user.application.useCase.input

import com.study.kotlin.user.application.command.input.UpdateUserCommand

interface UpdateUserUseCase {

    fun updateUser(updateUserCommand: UpdateUserCommand)
}
