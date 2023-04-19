package com.study.chat.member.adapter.input.response

import com.fasterxml.jackson.annotation.JsonFormat
import com.study.chat.global.domain.JwtToken
import com.study.chat.member.domain.Member
import java.time.LocalDateTime

class SignInResponse(member: Member, jwt: JwtToken) {
    val id: Long = member.id
    val username = member.username
    val token: String = jwt.value!!

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    val signInAt: LocalDateTime = LocalDateTime.now()
}
