package com.study.kotlin.lecture_01

fun main() {
    // 가변 변수 > var 키워드를 사용한다.
    // var 키워드를 선언한 변수는 값 변경이 가능하다.
    var variable = 10L
    variable *= variable

    // 불변 변수 > val 키워드를 사용한다.
    // val 키워드를 선언한 변수는 값 변경이 불가능하다.
    val immutable = 10L

    // Kotlin 에서는 타입 추론을 지원한다.
    // 따라서 별도로 타입을 지정하지 않아도 되지만 원하는 경우 타입 지정이 가능하다.
    // 또한 변수는 무조건 초기화를 해야 한다.
    var message: String = "Hello"
    message += " "
    message += "World"

    // Tip. val 키워드는 element 를 추가 할 수 있다.
    // Tip. 변수 선언 시 클린 코드를 위해서 val 키워드 변수로 선언 후 필요하다면 var 키워드를 사용하는 것이 좋다.

    println("variable : ${variable}, immutable : ${immutable}, message : $message")
}