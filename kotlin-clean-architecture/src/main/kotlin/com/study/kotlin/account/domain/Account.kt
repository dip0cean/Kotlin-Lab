package com.study.kotlin.account.domain

/**
 * Account 엔티티는 실제 계좌의 현재 스냅샷을 제공한다.
 * 계좌에 대한 모든 입금과 출금은 Activity 엔티티에서 포착된다.
 *
 * UseCase 는 Incoming Adapter 를 통해 입력을 받는다.
 * 입력 유효성 검증은 별도의 계층에서 처리하고, UseCase 에서는 비즈니스 규칙을 검증해야 할 책임이 있다.
 * 또한, Domain 엔티티와 이 책임을 공유한다.
 */
data class Account(
    val id: String,
    // 활동창(ActivityWindow) 의 첫 번째 활동 바로 전의 잔고 표현
    val baseLineBalance: Money,
    val activityWindow: ActivityWindow
) {

    fun calculateBalance(): Money {
        return Money.add(
            this.baseLineBalance,
            this.activityWindow.calculateBalance(this.id)
        )
    }

    // 입금 함수
    fun withdraw(money: Money, targetAccountId: String): Boolean {
        // 비즈니스 규칙 검증
        // 도메인 엔티티 내부에서 비즈니스 규칙을 검증하도록 한다.
        // 이렇게 처리할 경우 비즈니스 로직과 규칙을 추론하기 수월하다.
        // 만약 도메인 엔티티에서 처리하기 힘든 경우, UseCase 의 비즈니스 로직 수행 전에 규칙 검증을 수행해도 된다.
        return if (!mayWithdraw(money)) false else {
            val withdrawal = Activity()
            true
        }
    }

    // 출금 함수
    fun deposit(money: Money, sourceAccountId: String): Boolean {
        val deposit = Activity(
            ownerAccountId = this.id,
            sourceAccountId = sourceAccountId,
            targetAccountId = this.id,
            money = money
        )
        this.activityWindow.addActivity(deposit)
        return true
    }

    private fun mayWithdraw(money: Money): Boolean {
        return Money.add(
            this.calculateBalance(),
            money.negate()
        ).isPositive()
    }
}
