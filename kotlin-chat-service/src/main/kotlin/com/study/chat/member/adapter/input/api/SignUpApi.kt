package com.study.chat.member.adapter.input.api

import com.study.chat.member.adapter.input.request.SignUpRequest
import com.study.chat.member.adapter.input.response.SignUpResponse
import com.study.chat.member.application.port.input.SignUpUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/members")
class SignUpApi(private val signUpUseCase: SignUpUseCase) {
    @PostMapping
    fun signUp(@RequestBody request: SignUpRequest): ResponseEntity<SignUpResponse> {
        val username = signUpUseCase.signUp(request.username, request.password)
        val response = SignUpResponse(username)
        return ResponseEntity.ok(response)
    }
}
