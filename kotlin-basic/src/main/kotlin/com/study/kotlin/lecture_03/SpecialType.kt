package com.study.kotlin.lecture_03

fun main() {
    // Any
    // Java 의 Object 역할을 하며 모든 객체의 최상위 타입이다.
    // 따라서 Int, Long 같은 Primitive Type 의 최상위 타입도 Any 이다.
    // Any 자체로는 null 을 표현 할 수 없으나, Any? 를 통해 사용 가능하다.
    // equals() / hasCode() / toString() 함수가 존재한다.
    val any: Any = 10L
    val number: Int = (any as Long).toInt()

    // Unit
    // Java 의 Void 클래스와 같은 존재이다.
    // void 와 다르게 Unit 은 그 자체로 사용 가능하다.
    // 그 이유는 함수형 프로그래밍에서 Unit 은 단 하나의 인스턴스만 갖는 타입을 의미하기 때문디ㅏ. (실제 존재하는 타입)
    val unit = getUnit()
    val isUnit = isUnit(unit)
    val isNotUnit = isUnit(number)

    println("any : ${any::class}, number : ${number::class}, unit : ${unit::class}, isUnit : ${isUnit}, isNotUnit : $isNotUnit")
}

fun isUnit(unit: Any): Boolean = unit is Unit

fun getUnit() {

}

/**
 * Nothing
 * Nothing 타입은 함수가 정상적으로 끝나지 않았다는 사실을 표현하는 역할을 가진다.
 * 무조건 예외를 반환하는 함수 / 무한 루프 등
 */
fun getNothing(): Nothing {
    throw NullPointerException()
}