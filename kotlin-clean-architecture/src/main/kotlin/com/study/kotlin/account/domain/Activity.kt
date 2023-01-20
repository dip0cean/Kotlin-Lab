package com.study.kotlin.account.domain

import java.time.LocalDateTime

data class Activity(
    val id: String = "",
    val ownerAccountId: String = "",
    val sourceAccountId: String = "",
    val targetAccountId: String = "",
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val money: Money = Money()
)
