package com.study.kotlin.programmers.day_5

// https://school.programmers.co.kr/learn/courses/30/lessons/120819
fun main() {
    val result = solution(15_500)
    println("잔 수 : ${result[0]}, 거스름 돈 : ${result[1]}")
}

private const val PRICE = 5_500

private fun solution(money: Int): IntArray = intArrayOf(money / PRICE, money % PRICE)