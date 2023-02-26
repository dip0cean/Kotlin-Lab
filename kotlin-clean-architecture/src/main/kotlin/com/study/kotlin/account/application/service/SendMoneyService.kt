package com.study.kotlin.account.application.service

import com.study.kotlin.account.application.port.input.SendMoneyCommand
import com.study.kotlin.account.application.port.input.SendMoneyUseCase
import com.study.kotlin.account.application.port.output.AccountLock
import com.study.kotlin.account.application.port.output.LoadAccountPort
import com.study.kotlin.account.application.port.output.UpdateAccountStatePort
import com.study.kotlin.common.UseCase
import jakarta.transaction.Transactional
import java.time.LocalDateTime

@UseCase
@Transactional
private class SendMoneyService(
    private val loadAccountPort: LoadAccountPort,
    private val updateAccountStatePort: UpdateAccountStatePort,
    private val accountLock: AccountLock,
    private val moneyTransferProperties: MoneyTransferProperties
) : SendMoneyUseCase {

    override fun sendMoney(command: SendMoneyCommand): Boolean {
        val baseLineDate = LocalDateTime.now().minusDays(10)

        val sourceAccount = loadAccountPort.loadAccount(command.sourceAccountId, baseLineDate)
        val targetAccount = loadAccountPort.loadAccount(command.targetAccountId, baseLineDate)

        val sourceAccountId = sourceAccount.id
        val targetAccountId = targetAccount.id

        accountLock.lock(sourceAccountId)
        accountLock.lock(targetAccountId)

        return when {
            !sourceAccount.withdraw(command.money, targetAccountId) -> {
                accountLock.release(sourceAccountId)
                false
            }

            !targetAccount.deposit(command.money, sourceAccountId) -> {
                accountLock.release(sourceAccountId)
                accountLock.release(targetAccountId)
                false
            }

            else -> {
                updateAccountStatePort.updateActivities(sourceAccount)
                updateAccountStatePort.updateActivities(targetAccount)

                accountLock.release(sourceAccountId)
                accountLock.release(targetAccountId)

                true
            }
        }
    }

    private fun checkThreshold(command: SendMoneyCommand) {
        if (command.money.isGreaterThan(moneyTransferProperties.maximumTransferThreshold)) {
            throw ThresholdExceededException(moneyTransferProperties.maximumTransferThreshold, command.money)
        }
    }
}
