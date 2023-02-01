package com.study.kotlin.account.domain

import com.study.kotlin.Mock
import com.study.kotlin.Mock.account
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.single
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify

class AccountTest : ExpectSpec() {

    init {
        context("계좌 정보의") {
            val money = Mock.money().single(RandomSource.default())
            val activityWindow = Mock.activityWindow(10..99).single(RandomSource.default())
            val account = spyk(account(money, activityWindow).single(RandomSource.default()))

            expect("현재 잔고를 출력한다.") {
                every { account.id } returns 0L
                every { account.calculateBalance() } returns Money(1000L)

                val balance = account.calculateBalance()

                balance.amount() shouldBe 1000L
                verify(exactly = 1) { account.calculateBalance() }
            }
        }
    }
}
