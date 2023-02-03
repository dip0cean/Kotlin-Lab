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
        val money = Mock.money().single(RandomSource.default())
        val activityWindow = Mock.activityWindow(0..10).single(RandomSource.default())
        val account = spyk(account(money, activityWindow).single(RandomSource.default()))

        context("계좌 정보의") {

            expect("현재 잔고를 출력한다.") {
                every { account.id } returns 0L
                every { account.calculateBalance() } returns Money(1000L)

                val balance = account.calculateBalance()

                balance.amount() shouldBe 1000L
                verify(exactly = 1) { account.calculateBalance() }
            }
        }

        context("현재 계좌에") {
            val otherMoney = Mock.money().single(RandomSource.default())
            val otherActivityWindow = Mock.activityWindow(0..10).single(RandomSource.default())
            val otherAccount = spyk(account(otherMoney, otherActivityWindow).single(RandomSource.default()))

            expect("n원을 출금한다.") {
                every { account.withdraw(otherMoney, otherAccount.id) } returns true

                val beforeBalance = account.calculateBalance() - otherMoney
                val withdrawalResult = account.withdraw(otherMoney, otherAccount.id)

                withdrawalResult shouldBe true
                account.calculateBalance().amount() shouldBe beforeBalance.amount()

                verify { account.withdraw(otherMoney, otherAccount.id) }
            }
        }
    }
}
