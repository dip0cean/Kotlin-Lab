package com.study.kotlin.account.domain

import java.math.BigInteger

class Money(
    amount: Long
) {
    private val amount: BigInteger = BigInteger.valueOf(amount)

    fun negate(): Money = Money(this.amount.negate().longValueExact())

    fun isPositive(): Boolean = this.amount > BigInteger.ZERO

    companion object {
        fun add(baseLineBalance: Money, calculateBalance: Money): Money {
            return Money(baseLineBalance.amount.add(calculateBalance.amount).longValueExact())
        }
    }
}
