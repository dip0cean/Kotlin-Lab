package com.study.kotlin.lecture_16

fun main() {
    val message = "Hello World"
    println(message.lastChar())

    // 멤버 함수와 시그니처가 같은 확장 함수 정의 시 멤버 함수가 호출된다.
    val person = Person("심성헌", 19)
    println(person.isAdult())

    // 확장 함수는 정적 타입에 따라 호출 함수가 달라진다.
    // Train 확장 함수 호출
    val train1 = Train(50_000)
    println(train1.isExpensive())

    // Train 확장 함수 호출
    val train2: Train = KTX()
    println(train2.isExpensive())

    // KTX 확장 함수 호출
    val train3 = KTX()
    println(train3.isExpensive())

    // 확장 프로퍼티의 원리는 확장 함수 + custom getter 와 동일하다.
    println(train3.destination)
}

// String 클래스를 확장한다.
fun String.lastChar(): Char {
    // this 를 이용해 실제 클래스 안의 값에 접근하다.
    // 이 때의 this 를 수신 객체 타입이라고 한다.
    return this[this.length - 1]
}

class Person(
    val name: String,
    val age: Int
) {

    fun isAdult(): Boolean {
        println("멤버 함수")
        return this.age > 19
    }
}

fun Person.isAdult(): Boolean {
    println("확장 함수")
    return this.isAdult()
}

open class Train(
    val ticketPrice: Int
)

fun Train.isExpensive(): Boolean {
    println("Train 확장 함수")
    return this.ticketPrice > 50_000
}

class KTX : Train(50_000)

fun KTX.isExpensive(): Boolean {
    println("KTX 확장 함수")
    return this.ticketPrice > 100_000
}

val KTX.destination: String
    get() = "서울역"

