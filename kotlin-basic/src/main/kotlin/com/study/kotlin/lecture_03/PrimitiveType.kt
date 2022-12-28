package com.study.kotlin.lecture_03

fun main() {
    // Kotlin 에서는 L(Long) / f(Float) 키워드를 통해 타입을 추론하여 기본 타입을 지정한다.
    val number1 = 30 // Int
    val number2 = 1000L // Long > L 키워드를 붙이면 Long 으로 추론
    val number3 = 0.0f // Float > f 키워드를 붙이면 Float 으로 추론
    val number4 = 0.0 // Double

    // Kotlin 에서는 기본 타입 간 변환은 명시적으로 이뤄지기 때문에 처음 초기화된 데이터의 타입을 기준으로 한다.
    // Java
    // int number1 = 10; > Primitive Type int
    // long number2 = 10; > Primitive Type long

    // Kotlin
    // number2 = number1 // Type Mismatch 컴파일 에러 발생
    // 이를 해결하기 위해서 toType() 함수를 사용해야 한다.
    val number5 = 1_000
    val number6: Long = number5.toLong()
    // 연산을 통한 타입 변화에 대해서도 toType() 함수를 사용해 어떤 타입의 결과를 반환할지 지정 해줘야 한다.
    val number7: Double? = number1 / number2.toDouble()

    // Nullable 인 경우, Elvis 연산을 이용한다.
    val number8: Long = number7?.toLong() ?: 0L

    println("number1 : ${number1::class}, number2 : ${number2::class}, number3 : ${number3::class}, number4 : ${number4::class}, number5 : ${number5::class}, number6 : ${number6::class}")
}