package com.study.kotlin.lecture_12

class Person private constructor(
    var name: String,
    var age: Int
) {

    // 동행 객체
    companion object Factory : Log {

        private const val MIN_AGE = 1

        @JvmStatic
        fun newBaby(name: String) = Person(name, MIN_AGE)

        override fun log() {
            println("Person Companion Object")
        }
    }
}

fun main() {
    val baby = Person.newBaby("심또꼬망")
    println(baby.name)
}