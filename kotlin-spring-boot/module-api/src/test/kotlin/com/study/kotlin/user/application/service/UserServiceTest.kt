package com.study.kotlin.user.application.service

import com.study.kotlin.extension.age
import com.study.kotlin.extension.id
import com.study.kotlin.extension.name
import com.study.kotlin.user.application.command.input.RegisterUserCommand
import com.study.kotlin.user.application.port.input.RegisterUserPort
import com.study.kotlin.user.application.port.input.UpdateUserPort
import com.study.kotlin.user.application.port.output.GetUserPort
import com.study.kotlin.user.domain.User
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.chunked
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.single
import io.mockk.every
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

        expect("모든 유저 조회") {
            val user = Arb.of(
                User(
                    id = Arb.id(),
                    name = Arb.name(),
                    age = Arb.age()
                )
            )
            every { userService.getAllUser() } returns user.chunked(10..10)
                .single(RandomSource.default())

            val userList = userService.getAllUser()

            userList.size shouldBe 10
        }
    }
})
