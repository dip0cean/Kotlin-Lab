package com.study.kotlin.account.domain

import java.math.BigInteger

class Money(
    amount: Long = 0L
) {

    private val decimalAmount: BigInteger = BigInteger.valueOf(amount)

    fun negate(): Money = Money(this.decimalAmount.negate().longValueExact())

    fun isPositive(): Boolean = this.decimalAmount > BigInteger.ZERO

    fun isPositiveOrZero(): Boolean = this.decimalAmount >= BigInteger.ZERO

    fun isGreaterThanOrEqualTo(money: Money): Boolean = this.decimalAmount >= money.decimalAmount

    fun isGreaterThan(money: Money): Boolean = this.decimalAmount > money.decimalAmount

    operator fun plus(calculateBalance: Money): Money =
        Money((this.amount() + calculateBalance.amount()))

    operator fun minus(calculateBalance: Money): Money =
        Money((this.amount() - calculateBalance.amount()))

    fun amount(): Long = decimalAmount.longValueExact()
}
