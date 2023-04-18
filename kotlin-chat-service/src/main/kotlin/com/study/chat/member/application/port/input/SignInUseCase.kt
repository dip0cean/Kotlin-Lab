package com.study.chat.member.application.port.input

interface SignInUseCase {
    fun signIn(username: String, password: String): String
}
