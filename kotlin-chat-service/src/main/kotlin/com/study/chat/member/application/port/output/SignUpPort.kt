package com.study.chat.member.application.port.output

import com.study.chat.member.domain.Member

interface SignUpPort {
    fun signIn(member: Member): Member
}
