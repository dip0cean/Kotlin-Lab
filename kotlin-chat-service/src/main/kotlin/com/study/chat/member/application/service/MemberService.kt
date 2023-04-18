package com.study.chat.member.application.service

import com.study.chat.member.application.port.input.SignInUseCase
import com.study.chat.member.application.port.output.FindMemberPort
import com.study.chat.member.application.port.output.SignInPort
import com.study.chat.member.domain.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val signInPort: SignInPort,
    private val findMemberPort: FindMemberPort,
    private val passwordEncoder: PasswordEncoder
) : SignInUseCase {
    override fun signIn(username: String, password: String): String {
        val member = findMemberPort.findMember(username)
        if (member != null) throw IllegalArgumentException("동일한 아이디가 존재합니다.")
        val newMember = Member(username = username, password = passwordEncoder.encode(password))
        return signInPort.signIn(newMember).username
    }
}
