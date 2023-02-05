package com.study.kotlin.programmers.day_4

import java.math.BigInteger
import kotlin.math.ceil

// https://school.programmers.co.kr/learn/courses/30/lessons/120814
fun main() {
    val result = solution(15)
    val resultCleanCode = solutionCleanCode(15)
    println("result : $result, resultCleanCode : $resultCleanCode")
}

private val piece = BigInteger.valueOf(7L)

private fun solution(n: Int): Int {
    val personnel = BigInteger.valueOf(n.toLong())

    return personnel.divide(piece)
        .add(if (personnel.remainder(piece) == BigInteger.ZERO) BigInteger.ZERO else BigInteger.ONE).toInt()
}

/**
 * ceil(value: Double) / ceil(value: Float)
 * - ceil() 은 Kotlin 기본 내장 함수로 나머지 값에 대한 반올림한 결과를 반환하는 함수이다.
 */
fun solutionCleanCode(n: Int): Int = ceil(n / 7.0).toInt()