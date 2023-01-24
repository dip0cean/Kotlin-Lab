package com.study.kotlin.account.adapter.input.web

import com.study.kotlin.account.application.port.input.SendMoneyCommand
import com.study.kotlin.account.application.port.input.SendMoneyUseCase
import com.study.kotlin.account.domain.Money
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
private class AccountController(
    private val sendMoneyUseCase: SendMoneyUseCase
) {

    @PostMapping("/accounts/send/{sourceAccountId}/{targetAccountId}/{amount}")
    fun sendMoney(
        @PathVariable("sourceAccountId") sourceAccountId: String,
        @PathVariable("targetAccountId") targetAccountId: String,
        @PathVariable("amount") amount: Long
    ) {
        val command = SendMoneyCommand(sourceAccountId, targetAccountId, Money(amount))
        sendMoneyUseCase.sendMoney(command)
    }
}
