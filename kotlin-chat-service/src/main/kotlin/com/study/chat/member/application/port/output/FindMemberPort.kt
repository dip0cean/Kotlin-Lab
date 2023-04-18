package com.study.chat.member.application.port.output

import com.study.chat.member.domain.Member

interface FindMemberPort {
    fun findMember(username: String): Member?
}
