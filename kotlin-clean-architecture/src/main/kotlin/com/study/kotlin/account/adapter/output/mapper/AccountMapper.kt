package com.study.kotlin.account.adapter.output.mapper

import com.study.kotlin.account.adapter.output.entity.EAccount
import com.study.kotlin.account.adapter.output.entity.EActivity
import com.study.kotlin.account.domain.Account
import com.study.kotlin.account.domain.Activity
import com.study.kotlin.account.domain.ActivityWindow
import com.study.kotlin.account.domain.Money
import org.springframework.stereotype.Component

@Component
class AccountMapper {

    fun mapToDomain(
        account: EAccount,
        activities: List<EActivity>,
        withdrawalBalance: Long,
        depositBalance: Long
    ): Account {
        val baseLineBalance = Money(depositBalance).subtract(Money(withdrawalBalance))
        return Account(
            id = account.id, baseLineBalance = baseLineBalance
        )
    }

    fun mapToActivityWindow(activities: List<EActivity>): ActivityWindow =
        ActivityWindow(
            activities.map {
                Activity(
                    id = it.id,
                    ownerAccountId = it.ownerAccountId,
                    sourceAccountId = it.sourceAccountId,
                    targetAccountId = it.targetAccountId,
                    money = Money(it.amount),
                    timeStamp = it.timeStamp
                )
            }.toMutableList()
        )

    fun mapToEntity(activity: Activity): EActivity = EActivity(
        ownerAccountId = activity.ownerAccountId,
        sourceAccountId = activity.sourceAccountId,
        targetAccountId = activity.targetAccountId,
        amount = activity.money.amount()
    )
}
