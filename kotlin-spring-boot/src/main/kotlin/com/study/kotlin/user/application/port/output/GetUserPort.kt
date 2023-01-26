package com.study.kotlin.user.application.port.output

import com.study.kotlin.user.domain.User

interface GetUserPort {

    fun getAllUser(): List<User>

    fun getUser(id: Long): User
}
