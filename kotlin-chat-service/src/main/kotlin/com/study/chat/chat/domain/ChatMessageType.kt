package com.study.chat.chat.domain

enum class ChatMessageType(val prefix: String) {
    TOPIC("/topic"),
    QUEUE("/queue")
}
