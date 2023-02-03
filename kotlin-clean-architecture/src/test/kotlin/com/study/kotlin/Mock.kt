package com.study.kotlin

import com.study.kotlin.account.domain.Account
import com.study.kotlin.account.domain.Activity
import com.study.kotlin.account.domain.ActivityWindow
import com.study.kotlin.account.domain.Money
import io.kotest.property.Arb
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.chunked
import io.kotest.property.arbitrary.localDateTime
import io.kotest.property.arbitrary.long
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.single

object Mock {

    fun activity() = Arb.of(
        Activity(
            id = Arb.long(0L..100L).single(RandomSource.default()),
            ownerAccountId = Arb.long(0L..0L).single(RandomSource.default()),
            sourceAccountId = Arb.long(0L..0L).single(RandomSource.default()),
            targetAccountId = Arb.long(0L..0L).single(RandomSource.default()),
            timeStamp = Arb.localDateTime(2022, 2023).single(RandomSource.default()),
            money = money().single(RandomSource.default())
        )
    )

    private fun activities(range: IntRange) = activity().chunked(range)

    fun activityWindow(range: IntRange) =
        Arb.of(ActivityWindow(activities(range).single(RandomSource.default()).toMutableList()))

    fun money() = Arb.of(Money(Arb.long(1000L..10000L).single(RandomSource.default())))

    fun account(baseLineBalance: Money, activityWindow: ActivityWindow) = Arb.of(
        Account(
            id = Arb.long(0L..0L).single(RandomSource.default()),
            baseLineBalance = baseLineBalance,
            activityWindow = activityWindow
        )
    )
}
