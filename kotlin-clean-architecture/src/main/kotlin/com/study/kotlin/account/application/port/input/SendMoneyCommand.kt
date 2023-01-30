package com.study.kotlin.account.application.port.input

import com.study.kotlin.account.domain.Money
import com.study.kotlin.common.SelfValidating
import jakarta.validation.constraints.NotNull

/**
 * 해당 클래스는 입력 모델로 UseCase 로 입력을 전달하기 전에 클라이언트로부터
 * 입력 받은 데이터에 대한 유효성을 검사하는 역할을 맡는다.
 *
 * SendMoneyCommand 는 UseCase API 의 일부이기 때문에 Incoming Port 패키지에 위치한다.
 * 그러므로 유효성 검증이 애플리케이션 코어에 남아 있지만 UseCase 코드(즉, 도메인 계층의 비즈니스 로직)을 오염시키지 않는다.
 */
data class SendMoneyCommand(
    @NotNull
    val sourceAccountId: Long = 0L,
    @NotNull
    val targetAccountId: Long = 0L,
    @NotNull
    val money: Money = Money(0L)
) : SelfValidating<SendMoneyCommand>() {

    init {
        this.validateSelf()
    }
}
