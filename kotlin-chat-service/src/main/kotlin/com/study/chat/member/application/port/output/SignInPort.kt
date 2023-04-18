package com.study.chat.member.application.port.output

import com.study.chat.member.domain.Member

interface SignInPort {
    fun signIn(member: Member): Member
}
