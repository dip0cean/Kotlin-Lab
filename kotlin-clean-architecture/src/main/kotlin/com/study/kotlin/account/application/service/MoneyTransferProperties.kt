package com.study.kotlin.account.application.service

import com.study.kotlin.account.domain.Money

class MoneyTransferProperties(
    val maximumTransferThreshold: Money = Money(1_000_000L)
)
