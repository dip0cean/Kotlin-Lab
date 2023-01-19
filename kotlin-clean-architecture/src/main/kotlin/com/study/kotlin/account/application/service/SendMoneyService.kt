package com.study.kotlin.account.application.service

import com.study.kotlin.account.application.port.input.SendMoneyUseCase
import com.study.kotlin.account.application.port.output.LoadAccountPort
import com.study.kotlin.account.application.port.output.UpdateAccountStatePort
import com.study.kotlin.common.UseCase

@UseCase
private class SendMoneyService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountStatePort: UpdateAccountStatePort
) : SendMoneyUseCase {
}