package com.study.kotlin.user.application.service

import com.study.kotlin.extension.age
import com.study.kotlin.extension.name
import com.study.kotlin.user.application.command.input.RegisterUserCommand
import com.study.kotlin.user.application.port.input.RegisterUserPort
import com.study.kotlin.user.application.port.input.UpdateUserPort
import com.study.kotlin.user.application.port.output.GetUserPort
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.property.Arb
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UserServiceTest : ExpectSpec({

    context("유저 도메인 테스트") {
        val registerUserPort = mockk<RegisterUserPort>(relaxed = true)
        val getUserPort = mockk<GetUserPort>(relaxed = true)
        val updateUserPort = mockk<UpdateUserPort>(relaxed = true)
        val userService = spyk(UserService(registerUserPort, getUserPort, updateUserPort))

        expect("유저 등록") {
            val userCommand = RegisterUserCommand(
                name = Arb.name(),
                age = Arb.age()
            )

            withContext(Dispatchers.IO) {
                userService.registerUser(userCommand)
            }

            verify(exactly = 1) { registerUserPort.registerUser(any()) }
            verify(exactly = 1) { userService.registerUser(any()) }
        }
    }
})
