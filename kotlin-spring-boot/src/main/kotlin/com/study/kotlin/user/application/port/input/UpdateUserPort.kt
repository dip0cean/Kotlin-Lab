package com.study.kotlin.user.application.port.input

import com.study.kotlin.user.domain.User

interface UpdateUserPort {

    fun updateUser(user: User)
}
