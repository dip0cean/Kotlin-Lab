package com.study.chat.adapter.input.request

data class ChatRequest(
    val userId: Long,
    val groupId: Long,
    val message: String
)
