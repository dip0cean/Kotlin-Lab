package com.study.kotlin.lecture_03

private class Person(val age: Int)

fun main() {
    val person = Person(28)
    printAgeIfPerson(person)
    printAgeIfPersonOrNull(null)
}

fun printAgeIfPerson(obj: Any) {
    // Kotlin is == Java instanceof
    if (obj is Person) {
        // Kotlin as == Java Cast
        // val person = obj as Person // Smart Cast 를 통해 as 키워드는 생략 가능하다.
        // println("age : ${person.age}")
        println("age : ${obj.age}")
    }
}

fun printAgeIfPersonOrNull(obj: Any?) {
    val person = obj as? Person
    println("age : ${person?.age}")
}