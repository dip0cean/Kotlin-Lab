package com.study.kotlin.lecture_04

fun main() {

    val money1 = Money(1_000)
    val money2 = Money(2_000)
    val money3 = money2

    // Kotlin 에서는 <, >, <=, >= 를 사용하게 되면
    // 자동으로 compareTo 를 호출한다.
    if (money1 < money2) println("money1 은 money2 보다 작습니다.")
    if (money1 > money2) println("money2 는 money1 보다 큽니다.")
    if (money2 >= money3) println("money2 은 money3 과 같거나 큽니다.")
    if (money3 <= money2) println("money3 은 money2 와 같거나 작습니다.")

    // 비교 연산자
    // 동등성 > 두 객체의 값이 같은가?
    if (money1 !== money2) println("money1 과 money2 는 서로 다른 값이다.")
    if (money2 === money3) println("money2 와 money3 는 동일한 값이다.")
    // 동일성 > 완전히 동일한 객체인가? 주소가 같은가?
    if (money1 != money2) println("money1 과 money2 는 서로 다른 객체이다.") // equals()
    if (money2 == money2) println("money2 와 money3 는 동일한 객체이다.") // equals()

    // 논리 연산자
    // Kotlin 에서는 Java 와 동일하게 Lazy 연산을 지원한다.
    if (isTrue() || isFalse()) println("isTrue() 혹은 isFalse() 중 하나가 참인 경우 > isTure() 가 참이기 때문에 isFalse() 는 호출하지 않는다.")

    // in / !in > Collection 이나 범위의 포함 여부를 체크합니다.
    val list: List<Int> = listOf(1, 2, 3, 4, 5)
    if (1 in list) println("list 에는 1 이 포함되어 있다.")
    if (1_000 !in list) println("list 에는 1,000 이 포함되어 있지 않다.")

    // a..b > a 부터 b 까지 범위 객체를 생성한다.
    val range: IntRange = 1..10
    range.forEach { value -> println(value) }

    // a[i] > 특정 Index 에 존재하는 값을 가져온다.
    val map = mutableMapOf("초등학생" to 1..6, "중학생" to 1..3, "고등학생" to 1..3, "대학생" to 1..4)
    map["초등학생"] = 100..1000
    println("list[1] = ${list[1]}, map[\"초등학생\"] = ${map["초등학생"]}")

    // 연산자 Overloading
    println("money1 + money2 = ${money1 + money2}, money2 - money3 = ${money2 - money3}")
}

class Money(
    private val amount: Int
) : Comparable<Money> {

    override fun compareTo(other: Money): Int = amount.compareTo(other.amount)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false

        return true
    }

    override fun toString(): String {
        return "Money(amount=$amount)"
    }

    override fun hashCode(): Int = this.hashCode()

    operator fun plus(other: Money): Money = Money(this.amount + other.amount)

    operator fun minus(other: Money): Money = Money(this.amount - other.amount)
}

fun isTrue(): Boolean = true

fun isFalse(): Boolean = false
