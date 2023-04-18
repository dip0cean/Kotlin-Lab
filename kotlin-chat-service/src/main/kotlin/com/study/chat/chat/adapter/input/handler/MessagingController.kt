package com.study.chat.chat.adapter.input.handler

import com.study.chat.chat.domain.ChatMessage
import org.springframework.messaging.handler.annotation.MessageMapping
import org.springframework.messaging.handler.annotation.Payload
import org.springframework.messaging.simp.SimpMessagingTemplate
import org.springframework.stereotype.Controller

@Controller
class MessagingController(
    private val template: SimpMessagingTemplate
) {
    @MessageMapping("/message")
    fun message(
        @Payload message: ChatMessage
    ) {
        println("message : ${message.message}")
        template.convertAndSendToUser(message.toUserId, message.type.prefix, message)
    }
}
