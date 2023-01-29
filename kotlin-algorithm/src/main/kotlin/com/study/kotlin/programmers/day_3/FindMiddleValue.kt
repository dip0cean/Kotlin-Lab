package com.study.kotlin.programmers.day_3

// https://school.programmers.co.kr/learn/courses/30/lessons/120811
fun main() {
    val result = solution(intArrayOf(1, 2, 7, 10, 11))
    println(result)
}

fun solution(array: IntArray): Int = array.sorted()[array.size / 2]
