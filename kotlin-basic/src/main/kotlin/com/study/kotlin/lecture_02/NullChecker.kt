package com.study.kotlin.lecture_02

class NullChecker

fun main() {
    // Kotlin 에서는 null 이 가능한 타입을 완전히 다르게 취급한다.
    val result1: Boolean = startsWithA1("Apple")
    val result2: Boolean = startsWithA2(null)
    val result3: Boolean? = startsWithA3(null)
    val result4: Boolean = startsWithA4(null) // NPE 발생!

    // IllegalArgumentException: null 은 허용하지 않습니다.
    println("result1 : $result1, result2 : $result2, result3 : $result3, result4 : $result4")

    // Safe Call
    // Null 을 허용하는 변수인 경우 변수의 함수 호출 시 ?. 라는 Safe Call 을 사용해야 한다.
    // 사용하지 않을 경우 컴파일 에러가 발생하며, 만약 값이 null 인 경우 호출한 함수는 null 을 리턴한다.
    val message1: String? = "Hello World"
    println("message1.length() is ${message1?.length}")

    // Elvis 연산자
    val message2: String? = "안녕하세요. 세상 사람들!"
    val length = message2?.length ?: 0
    println("message2.length() is Not Zero? ${length != 0}")
    println(("message2.length() is Zero? ${length == 0}"))
}

fun startsWithA1(str: String?): Boolean = str?.startsWith("A") ?: throw IllegalArgumentException("null 은 허용하지 않습니다.")

fun startsWithA2(str: String?): Boolean = str?.startsWith("A") ?: false

fun startsWithA3(str: String?): Boolean? = str?.startsWith("A")

// !! 키워드는 파라미터 인자가 절대 null 이 아닌 경우에 사용, 만약 null 이 들어오면 NPE 가 발생한다.
fun startsWithA4(str: String?): Boolean = str!!.startsWith("A")
