package com.study.kotlin.account.adapter.output.persistence

import com.study.kotlin.account.adapter.output.mapper.AccountMapper
import com.study.kotlin.account.application.port.output.LoadAccountPort
import com.study.kotlin.account.application.port.output.UpdateAccountStatePort
import com.study.kotlin.account.domain.Account
import com.study.kotlin.common.PersistenceAdapter
import jakarta.persistence.EntityNotFoundException
import java.time.LocalDateTime

@PersistenceAdapter
private class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository,
    private val activityRepository: ActivityRepository,
    private val accountMapper: AccountMapper
) : LoadAccountPort,
    UpdateAccountStatePort {

    override fun loadAccount(accountId: Long, baselineDate: LocalDateTime): Account {
        val account = accountRepository.findById(accountId).orElseThrow { EntityNotFoundException() }

        val activities = activityRepository.findByOwnerSince(accountId, baselineDate)

        val withdrawalBalance = activityRepository.getWithdrawalBalanceUntil(accountId, baselineDate)

        val depositBalance = activityRepository.getDepositBalanceUntil(accountId, baselineDate)

        return accountMapper.mapToDomain(
            account,
            activities,
            withdrawalBalance,
            depositBalance
        )
    }

    override fun updateActivities(account: Account) {
        val activities = account.activityWindow.activities
            .filter { it.id != 0L }
            .map { accountMapper.mapToEntity(it) }
        activityRepository.saveAll(activities)
    }
}
