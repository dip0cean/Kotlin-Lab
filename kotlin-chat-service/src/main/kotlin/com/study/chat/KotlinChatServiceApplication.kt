package com.study.chat

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinChatServiceApplication

fun main(args: Array<String>) {
    runApplication<KotlinChatServiceApplication>(*args)
}
