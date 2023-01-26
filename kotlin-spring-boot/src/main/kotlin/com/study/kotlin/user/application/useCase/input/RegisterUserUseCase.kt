package com.study.kotlin.user.application.useCase.input

import com.study.kotlin.user.application.command.input.RegisterUserCommand

interface RegisterUserUseCase {
    fun registerUser(registerUserCommand: RegisterUserCommand)
}
