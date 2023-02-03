package com.study.kotlin.account.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.longs.shouldBeGreaterThan
import io.kotest.matchers.longs.shouldBeLessThan
import io.kotest.matchers.shouldBe
import io.kotest.property.Arb
import io.kotest.property.arbitrary.chunked
import io.kotest.property.arbitrary.long
import io.kotest.property.arbitrary.of
import io.kotest.property.arbitrary.single
import io.mockk.spyk
import io.mockk.verify

class AccountTest : ExpectSpec({
    context("현재 계좌의") {
        val accountId = Arb.long(0L..9L).single()
        val anonymousAccountId = Arb.long(10L..19L).single()
        val baseLineBalance = Money(Arb.long(10000L..49999L).single())
        val activityWindow = ActivityWindow(
            activities = Arb.of(
                Activity(
                    ownerAccountId = anonymousAccountId,
                    sourceAccountId = anonymousAccountId,
                    targetAccountId = accountId,
                    money = Money(Arb.long(1000L..1999L).single())
                )
            ).chunked(1..9).single().toMutableList()
        )
        val account = spyk(
            Account(
                id = accountId,
                baseLineBalance = baseLineBalance,
                activityWindow = activityWindow
            )
        )

        expect("잔고를 출력한다.") {
            val expectBalance = baseLineBalance + activityWindow.calculateBalance(accountId)
            val balance = account.calculateBalance()

            balance.amount() shouldBe expectBalance.amount()
            verify(exactly = 1) { account.calculateBalance() }
        }

        expect("x 에게 n 원을 송금한다.") {
            val balance = account.calculateBalance()
            val withdrawalMoney = Money(Arb.long(1000L..1999L).single())
            val withdrawalResult = account.withdraw(withdrawalMoney, anonymousAccountId)

            withdrawalResult shouldBe true
            account.calculateBalance().amount() shouldBeLessThan balance.amount()
            verify(exactly = 1) { account.withdraw(any(), any()) }
        }

        expect("x 에게 n 원 송금을 실패한다.") {
            val balance = account.calculateBalance()
            val withdrawalMoney = Money(Arb.long(50000L..99999L).single())
            val withdrawalResult = account.withdraw(withdrawalMoney, anonymousAccountId)

            withdrawalResult shouldBe false
            account.calculateBalance().amount() shouldBe balance.amount()
            verify(exactly = 2) { account.withdraw(any(), any()) }
        }

        expect("x 로부터 n 원을 입급 받는다.") {
            val balance = account.calculateBalance()
            val depositMoney = Money(Arb.long(1000L..1999L).single())
            val depositResult = account.deposit(depositMoney, anonymousAccountId)

            depositResult shouldBe true
            account.calculateBalance().amount() shouldBeGreaterThan balance.amount()
            verify(exactly = 1) { account.deposit(any(), any()) }
        }
    }
})
