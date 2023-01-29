package com.study.kotlin.programmers.day_2

// https://school.programmers.co.kr/learn/courses/30/lessons/120809
fun main() {
    val result = solution(intArrayOf(1, 2, 100, -99, 1, 2, 3))
    result.forEach { number -> println(number) }
}

fun solution(numbers: IntArray) = numbers.map { number -> number * 2 }
