package com.study.chat.adapter.input.handler

import com.study.chat.adapter.input.request.ChatRequest
import com.study.chat.adapter.input.response.ChatResponse
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.stereotype.Controller
import java.time.LocalDateTime

@Controller
class ChatController {

    @MessageMapping("/greeting")
    fun join(request: ChatRequest): ChatResponse =
        ChatResponse(request.userId, request.groupId, "[${request.userId}] : ${request.message}", LocalDateTime.now())
}
