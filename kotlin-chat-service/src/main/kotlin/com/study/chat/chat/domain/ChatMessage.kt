package com.study.chat.chat.domain

data class ChatMessage(
    val type: ChatMessageType,
    val toUserId: String,
    val fromUserId: String,
    val channelId: String,
    val message: String
)
