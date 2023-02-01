package com.study.kotlin

import com.study.kotlin.account.domain.Activity
import com.study.kotlin.account.domain.ActivityWindow
import com.study.kotlin.account.domain.Money
import io.kotest.property.Arb
import io.kotest.property.arbitrary.list
import io.kotest.property.arbitrary.localDateTime
import io.kotest.property.arbitrary.long
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.single

object Mock {

    fun activity() = Activity(
        id = Arb.long(0L..100L).single(),
        ownerAccountId = Arb.long(0L..99L).single(),
        sourceAccountId = Arb.long(100L..199L).single(),
        targetAccountId = Arb.long(200L..299L).single(),
        timeStamp = Arb.localDateTime(2022, 2023).single(),
        money = Money(Arb.long(1000L..10000L).single())
    )

    fun activities(range: IntRange) = Arb.list(Arb.of(activity()), range)

    fun activityWindow(range: IntRange) = ActivityWindow(activities(range).single().toMutableList())
}
