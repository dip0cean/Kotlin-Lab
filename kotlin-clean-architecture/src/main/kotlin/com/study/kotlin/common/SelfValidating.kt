package com.study.kotlin.common

import jakarta.validation.ConstraintViolation
import jakarta.validation.ConstraintViolationException
import jakarta.validation.Validation
import jakarta.validation.Validator

/**
 * 클라이언트로부터 전달 받은 데이터의 유효성 체크를 검사하기 위한 상속 가능 클래스이다.
 * 입력 모델(ex.SendMoneyCommand) 는 해당 추상 클래스를 상속 받아 자기 자신이 직접 입력 데이터의 유효성을 검사할 수 있도록 한다.
 */
open class SelfValidating<T> {

    private val validator: Validator = Validation.buildDefaultValidatorFactory().validator

    protected fun validateSelf() {
        val violations: Set<ConstraintViolation<T>> = this.validator.validate(this as T)
        if (violations.isNotEmpty()) {
            throw ConstraintViolationException(violations)
        }
    }
}
