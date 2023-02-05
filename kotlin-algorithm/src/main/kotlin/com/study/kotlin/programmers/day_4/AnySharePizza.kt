package com.study.kotlin.programmers.day_4

import kotlin.math.ceil

// https://school.programmers.co.kr/learn/courses/30/lessons/120816
fun main() {
    val result = solution(7, 10)
    println(result)
}

private fun solution(slice: Int, n: Int): Int = ceil(n / slice.toDouble()).toInt()