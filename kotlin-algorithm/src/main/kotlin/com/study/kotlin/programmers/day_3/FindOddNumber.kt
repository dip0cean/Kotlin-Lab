package com.study.kotlin.programmers.day_3

// https://school.programmers.co.kr/learn/courses/30/lessons/120813
private fun main() {
    val result = solution(10)
    result.forEach { number -> println(number) }
}

private fun solution(number: Int) = (1..number).filter { it % 2 != 0 }.sorted()
