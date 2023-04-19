package com.study.chat.member.adapter.input.api

import com.study.chat.global.domain.JwtToken
import com.study.chat.member.adapter.input.request.SignInRequest
import com.study.chat.member.adapter.input.response.SignInResponse
import com.study.chat.member.application.port.input.SignInUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members/sign-in")
class SignInApi(private val signInUseCase: SignInUseCase) {
    @PostMapping
    fun signIn(@RequestBody request: SignInRequest): ResponseEntity<SignInResponse> {
        val member = signInUseCase.signIn(request.username, request.password)
        val jwt = JwtToken(member.username, member.role)
        val response = SignInResponse(member, jwt)
        return ResponseEntity.ok(response)
    }
}
