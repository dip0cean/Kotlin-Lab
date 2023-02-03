package com.study.kotlin.account.domain

import java.time.LocalDateTime

class ActivityWindow(
    val activities: MutableList<Activity> = mutableListOf()
) {

    fun getStartTimeStamp(): LocalDateTime =
        this.activities.minOfOrNull { it.timeStamp } ?: throw IllegalStateException()

    fun getEndTimeStamp(): LocalDateTime = this.activities.maxOfOrNull { it.timeStamp } ?: throw IllegalStateException()

    fun calculateBalance(accountId: Long): Money {
        val depositBalance = this.activities
            .filter { it.targetAccountId == accountId }
            .map { it.money }
            .reduceOrNull { acc, money -> acc + money } ?: Money()

        val withdrawalBalance = this.activities
            .filter { it.sourceAccountId == accountId }
            .map { it.money }
            .reduceOrNull { acc, money -> acc + money } ?: Money()

        return depositBalance + withdrawalBalance.negate()
    }

    fun addActivity(activity: Activity) {
        this.activities.add(activity)
    }
}
