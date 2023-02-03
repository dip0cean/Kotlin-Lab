package com.study.kotlin.account.domain

import java.math.BigInteger

data class Money(
    val amount: Long
) {

    private val decimalAmount: BigInteger = BigInteger.valueOf(this.amount)

    fun negate(): Money = Money(this.decimalAmount.negate().longValueExact())

    fun isPositive(): Boolean = this.decimalAmount > BigInteger.ZERO

    fun isPositiveOrZero(): Boolean = this.decimalAmount >= BigInteger.ZERO

    operator fun plus(calculateBalance: Money): Money =
        Money((this.amount + calculateBalance.amount))

    operator fun minus(calculateBalance: Money): Money =
        Money((this.amount - calculateBalance.amount))

    fun amount(): Long = decimalAmount.longValueExact()
}
