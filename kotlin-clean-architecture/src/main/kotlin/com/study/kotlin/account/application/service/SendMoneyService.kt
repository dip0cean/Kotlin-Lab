package com.study.kotlin.account.application.service

import com.study.kotlin.account.application.port.input.SendMoneyCommand
import com.study.kotlin.account.application.port.input.SendMoneyUseCase
import com.study.kotlin.account.application.port.output.LoadAccountPort
import com.study.kotlin.account.application.port.output.UpdateAccountStatePort
import com.study.kotlin.common.UseCase
import jakarta.transaction.Transactional

@UseCase
@Transactional
private class SendMoneyService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountStatePort: UpdateAccountStatePort
) : SendMoneyUseCase {

    override fun sendMoney(command: SendMoneyCommand): Boolean {
        TODO("비즈니스 규칙 검증")
        TODO("모델 상태 조작")
        TODO("출력 값 반환")
    }
}
