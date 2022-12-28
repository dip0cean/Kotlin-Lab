package com.study.kotlin.lecture_03

fun main() {
    // Java 에서는 동적으로 문자열을 제어하기 위해서 "" + "" 같은 표현식이나 StringBuilder 와 같은 클래스를 이용했다.
    // Kotlin 에서는 """ """ 를 사용하면 간편하게 문자열을 동적으로 제어 할 수 있다.
    val message = """
        To. 2023년의 나에게
            2022년 다사다난 했지만 잘 버텨준 내 자신. 고생 많았어!
            느려도 괜찮으니까 꾸준히 그리고 단단하게 성장하자!
        From. 2022년의 내가
    """.trimIndent()

    println(message)
}