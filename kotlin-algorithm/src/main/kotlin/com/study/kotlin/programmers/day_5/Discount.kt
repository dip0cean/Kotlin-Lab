package com.study.kotlin.programmers.day_5

import kotlin.math.floor

// https://school.programmers.co.kr/learn/courses/30/lessons/120818
fun main() {
    val result = solution(151_110)
    println(result)
}

// 10만원 이상 구매 시, 5% 할인
// 30만원 이상 구매 시, 10% 할인
// 50만원 이상 구매 시, 20% 할인
private fun solution(price: Int): Int = when {
    price in 100_000..299_999 -> floor(price - (price * 0.05)).toInt()
    price in 300_000..499_999 -> floor(price - (price * 0.1)).toInt()
    price >= 500_000 -> floor(price - (price * 0.2)).toInt()
    else -> price
}