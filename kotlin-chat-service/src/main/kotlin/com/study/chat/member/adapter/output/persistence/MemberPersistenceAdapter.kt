package com.study.chat.member.adapter.output.persistence

import com.study.chat.member.adapter.output.repository.MemberRepository
import com.study.chat.member.application.port.output.FindMemberPort
import com.study.chat.member.application.port.output.SignInPort
import com.study.chat.member.domain.Member
import org.springframework.stereotype.Component

@Component
class MemberPersistenceAdapter(
    private val memberRepository: MemberRepository
) : SignInPort, FindMemberPort {
    override fun signIn(member: Member): Member = memberRepository.save(member)

    override fun findMember(username: String): Member? = memberRepository.findByUsername(username)
}
