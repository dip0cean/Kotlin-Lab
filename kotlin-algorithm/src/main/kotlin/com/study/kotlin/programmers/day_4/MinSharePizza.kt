package com.study.kotlin.programmers.day_4

// https://school.programmers.co.kr/learn/courses/30/lessons/120815
fun main() {
    val result = solution(10)
    println(result)
}

private const val PIECE = 6

private fun solution(n: Int): Int = PIECE / gcd(n, PIECE)

private tailrec fun gcd(a: Int, b: Int): Int = if (b != 0) gcd(b, a % b) else a