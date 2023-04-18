package com.study.chat.adapter.input.response

import java.time.LocalDateTime

data class ChatResponse(
    val userId: Long,
    val groupId: Long,
    val message: String,
    val timestamp: LocalDateTime
)
