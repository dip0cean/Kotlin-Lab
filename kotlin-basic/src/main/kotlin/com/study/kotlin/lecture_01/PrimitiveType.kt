package com.study.kotlin.lecture_01

class PrimitiveType

fun main() {
    /**
     * Java Example
     * > Effective Java 에서는 Auto Boxing / UnBoxing 에 대한 불필요한 자원 낭비로 인해
     * > 연산을 해야 하는 경우 Reference Type 의 Wrapper Class 사용은 지양하는 것이 좋다고 말한다.
     * 1) long number1 = 10L;
     * 2) Long number2 = 10L;
     */
    // Kotlin 에서는 개발자가 Boxing / UnBoxing 을 고려하지 않아도 되게끔
    // JVM 단에서 Primitive Type 으로 컴파일하여 사용한다.
    var number1 = 10L
    val number2 = 1_000L

    // Kotlin Nullable
    // Null 이 허용한 변수라면 Type? 이라고 선언해야 한다.
    var number3: Long? = 1_000L
    number3 = null

    // 객체의 인스턴스화
    // Kotlin 에서는 객체를 인스턴스로 만들 때 Java 와 달리 new 키워드를 사용하지 않는다.
    var primitiveType = PrimitiveType()

    println("number1 : $number1, number2 : $number2, number3 is Null ? ${number3 == null}, primitiveType : $primitiveType")
}