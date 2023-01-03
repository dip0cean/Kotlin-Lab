package com.study.kotlin.lecture_06

fun main() {
    // Kotlin For 문의 동작 원리
    // .. 연산자 > 범위를 만들어 준다. IntProgression : IntRange 클래스를 사용해 구현한다.
    // 즉, 1..3 은 1 로 시작해서 3 으로 끝나는 "등차수열" 을 만들어 준다는 의미이다.
    // 3 downTo 1 은 3 으로 시작해서 1 로 끝나는 "등차수열" 을 만들어 준다.
    // 1..10 step 2 는 1 로 시작해 10 으로 끝나며 2 씩 커지는 "등차수열" 을 만들어 준다.
    // downTo, step 은 함수이다!

    val numbers = listOf(1, 2, 3)
    // Java 의 : 대신 in 을 사용한다.
    // Java 와 동일하게 Iterable 구현 클래스는 모두 사용 가능하다.
    for (number in numbers) {
        println(number)
    }

    // Java > for (int i = 1; i <= 3; i++)
    for (i in 1..3) {
        println(i)
    }

    // Java > for (int i = 3; i >= 1; i--)
    for (i in 3 downTo 1) {
        println(i)
    }

    // Java > for (int i = 1; i <= 5; i += 2)
    for (i in 1..5 step 2) {
        println(i)
    }

    // While
    var i = 1
    while (i <= 3) {
        println(i)
        i++
    }

    // do ~ while
    do {
        println(i)
        i++
    } while (i <= 10)
}