package com.study.chat.member.application.port.input

interface SignUpUseCase {
    fun signUp(username: String, password: String): String
}
