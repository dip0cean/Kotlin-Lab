package com.study.kotlin.account.domain

import java.math.BigInteger

class Money(
    amount: Long
) {
    private val amount: BigInteger = BigInteger.valueOf(amount)

    fun negate(): Money = Money(this.amount.negate().longValueExact())

    fun isPositive(): Boolean = this.amount > BigInteger.ZERO

    fun add(calculateBalance: Money): Money = Money((this.amount + calculateBalance.amount).longValueExact())

    fun subtract(calculateBalance: Money): Money = Money((this.amount - calculateBalance.amount).longValueExact())

    fun getAmount(): Long = this.amount.longValueExact()
}
