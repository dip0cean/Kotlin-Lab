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
    // Java 에서는 if-else 는 Statement 이지만, Kotlin 에서는 Expression 이다.
    return if (score >= 50) {
        "p"
    } else {
        "f"
    }
}

fun getGrade(score: Int): String {
    // if-else if 도 동일하게 사용 가능하다.
    return if (score >= 90) {
        "A"
    } else if (score >= 80) {
        "B"
    } else if (score >= 70) {
        "C"
    } else {
        "D"
    }
}

fun validateScore(score: Int) {
    // Java 0 >= score && score <= 100 같은 논리 연산을
    // Kotlin 에서는 in / !in 을 통해 간결하게 작성 할 수 있다.
    if (score in 0..100) {
        println("score 는 0 이상 100 이하에 포함됩니다.")
    }
}

fun getGradeWithSwitch(score: Int): String {
    // Java 의 Switch 는 when 으로 대신 사용 할 수 있으며
    // if-else 와 동일하게 하나의 Expression 이기 때문에 when 을 그대로 리턴할 수 있따.
    return when (score) {
        in 90..100 -> "A"
        in 80..89 -> "B"
        in 70..79 -> "C"
        else -> "D"
    }
}

fun startsWithA(obj: Any): Boolean {
    // is 와 when 을 이용해 간결하게 로직을 작성 할 수도 있다.
    return when (obj) {
        is String -> obj.startsWith("A")
        else -> false
    }
}

fun judgeNumber(number: Int) {
    // when 에서는 내부에 switch 에서 여러 case 를 처리하는 것과 같이
    // 하나의 Expression 내에 여러 개의 통과 조건을 설정 할 수 있다.
    when (number) {
        1, 0, -1 -> println("어디서 많이 본 숫자 입니다.")
        else -> println("1, 0, -1 이 아닙니다.")
    }
}

fun judgeNumber2(number: Int) {
    // 별도로 인자를 주입하지 않고, 각 Expression 별로 달리 계산하여
    // 통과 조건을 설정 할 수 있다.
    when {
        number == 0 -> println("주어진 숫자는 0 입니다.")
        number % 2 == 0 -> println("주어진 숫자는 짝수입니다.")
        else -> println("주어진 숫자는 홀수 입니다.")
    }
}