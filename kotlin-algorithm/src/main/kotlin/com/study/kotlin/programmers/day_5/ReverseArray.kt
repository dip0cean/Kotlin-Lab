package com.study.kotlin.programmers.day_5

// https://school.programmers.co.kr/learn/courses/30/lessons/120821
fun main() {
    val result = solution(intArrayOf(1, 2, 3, 4, 5, 6))
    result.forEach { println(it) }
}

private fun solution(array: IntArray): IntArray = array.reversedArray()