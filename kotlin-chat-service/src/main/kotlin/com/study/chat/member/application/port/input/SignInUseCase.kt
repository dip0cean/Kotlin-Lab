package com.study.chat.member.application.port.input

import com.study.chat.member.domain.Member

interface SignInUseCase {
    fun signIn(username: String, password: String): Member
}
