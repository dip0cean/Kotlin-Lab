package com.study.kotlin.account.domain

import java.math.BigInteger

class Money(
    amount: Long
) {
    private val amount: BigInteger = BigInteger.valueOf(amount)

    fun negate(): Money = Money(this.amount.negate().longValueExact())

    fun isPositive(): Boolean = this.amount > BigInteger.ZERO

    operator fun plus(calculateBalance: Money): Money =
        Money((this.amount + calculateBalance.amount).longValueExact())

    operator fun minus(calculateBalance: Money): Money =
        Money((this.amount - calculateBalance.amount).longValueExact())

    fun amount(): Long = this.amount.longValueExact()
}
