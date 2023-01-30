package com.study.kotlin.account.domain

import java.time.LocalDateTime

data class Activity(
    val id: Long = 0L,
    val ownerAccountId: Long = 0L,
    val sourceAccountId: Long = 0L,
    val targetAccountId: Long = 0L,
    val timeStamp: LocalDateTime = LocalDateTime.now(),
    val money: Money = Money(0L)
)
