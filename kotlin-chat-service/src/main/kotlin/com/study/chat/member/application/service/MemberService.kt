package com.study.chat.member.application.service

import com.study.chat.member.application.port.input.SignInUseCase
import com.study.chat.member.application.port.input.SignUpUseCase
import com.study.chat.member.application.port.output.FindMemberPort
import com.study.chat.member.application.port.output.SignUpPort
import com.study.chat.member.domain.Member
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional
class MemberService(
    private val signUpPort: SignUpPort,
    private val findMemberPort: FindMemberPort,
    private val passwordEncoder: PasswordEncoder,
) : SignUpUseCase, SignInUseCase {
    override fun signUp(username: String, password: String): String {
        val member = findMemberPort.findMember(username)
        if (member != null) throw IllegalArgumentException("동일한 아이디가 존재합니다.")
        val newMember = Member(username = username, password = passwordEncoder.encode(password))
        return signUpPort.signIn(newMember).username
    }

    @Transactional(readOnly = true)
    override fun signIn(username: String, password: String): Member {
        val member = findMemberPort.findMember(username) ?: throw IllegalArgumentException("유저명 혹은 비밀번호가 올바르지 않습니다.")
        if (!passwordEncoder.matches(password, member.password)) throw IllegalArgumentException("유저명 혹은 비밀번호가 올바르지 않습니다.")
        return member
    }
}
