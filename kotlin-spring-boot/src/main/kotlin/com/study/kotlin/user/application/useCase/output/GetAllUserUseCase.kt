package com.study.kotlin.user.application.useCase.output

import com.study.kotlin.user.domain.User

interface GetAllUserUseCase {

    fun getAllUser(): List<User>
}
