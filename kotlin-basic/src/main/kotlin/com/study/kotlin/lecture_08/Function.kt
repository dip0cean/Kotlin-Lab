package com.study.kotlin.lecture_08

fun main() {
    val max = max(1, 2)
    println(max)

    repeat("Hello World")
    // Default Argument
    repeat("I LUV U", 5)
    // Named Argument
    // Named Argument 는 Builder 의 특징을 가지기 때문에 유연하게 코드 작성이 가능하다.
    // Java 함수를 호출할 때는 Named Argument 를 사용 할 수 없다.
    repeat("Good Morning", useNewLine = false)

    printAll("A", "B", "C")
    // 배열을 인자로 전달하는 경우 * 키워드를 추가해줘야 한다.
    val arr = arrayOf("A", "B", "C")
    printAll(*arr)
}

// public 은 생략 가능하다.
// return 이 존재한다면 타입은 생략 가능하다.
// { } 을 사용하는 경우, Unit 이 아닌 경우 명시적으로 타입을 정의해줘야 한다.
// 함수는 클래스 내부에 존재 할 수도 파일에 여러 함수가 존재 할 수도 파일 최상단에 별도로 존재 할 수도 있다.
fun max(a: Int, b: Int) = if (a > b) a else b

// Kotlin 에서는 인자로 넘어오는 파라미터의 기본값을 지정해줄수 있다.
fun repeat(str: String, numbers: Int = 3, useNewLine: Boolean = true) {
    for (number in 1..numbers) {
        if (useNewLine) println(str) else print(str)
    }
}

// Kotlin 에서 가변인자는 vararg 키워드를 붙여줘야 한다.
fun printAll(vararg messages: String) {
    for (message in messages) println(message)
}
