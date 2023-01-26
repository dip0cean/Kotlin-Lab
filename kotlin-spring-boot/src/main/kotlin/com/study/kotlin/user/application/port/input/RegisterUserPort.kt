package com.study.kotlin.user.application.port.input

import com.study.kotlin.user.application.command.input.RegisterUserCommand

interface RegisterUserPort {

    fun registerUser(registerUserCommand: RegisterUserCommand)
}
