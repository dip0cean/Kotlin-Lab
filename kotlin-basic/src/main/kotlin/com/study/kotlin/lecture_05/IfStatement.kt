package com.study.kotlin.lecture_05

fun validateScoreIsNotNagative(score: Int) {
    // New 를 사용하지 않고 예외를 처리
    if (score < 0) {
        throw IllegalStateException("$score 는 0 보다 작을 수 없습니다.")
    }
}

fun getPassOrFail(score: Int): String {
    // Kotlin 에서 조건문은 Expression 이다.
    // 때문에 조건문을 그대로 반환 할 수 있으며, 삼항 연산자를 지원하지 않는다.
    return if (score >= 50) {
        "p"
    } else {
        "f"
    }
}