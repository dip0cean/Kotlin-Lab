package com.study.kotlin.programmers.exam

fun main() {
    val openA = intArrayOf(4,7,9,16)
    val closeB = intArrayOf(2,5,12,14,20)

    val result = solution(openA, closeB)
    println(result)
}

private fun solution(openA: IntArray, closeB: IntArray): Int {
    val max = closeB.reduce { current, next -> if (current > next) current else next }
    // 0 > 닫혀 있음
    // 1 > 열었음
    // 2 > 닫았음
    val times = MutableList(max + 1) { 0 }
    // 열린 시간 체크
    openA.reduce { current, next ->
        (current..next).forEach { times[it] = 1 }
        next
    }

    // 닫힌 시간 체크
    closeB.forEach { times[it] = 2 }

    var result = 0
    times.reduceIndexed { index, acc, i ->
        if (index + 1 <= times.lastIndex) {
            val nextIndex = index + 1
            if (acc == 0 && i == 1 && times[index + 1] == 2) {
                println("$index 추가")
                result++
            }
            if (acc == 2 && i == 1 && times[index + 1] == 1) {
                println("$index 추가")
                result++
            }
            if (acc == 1 && i == 1 && times[index + 1] == 1) {
                println("$index 추가")
                result++
            }
            if (acc == 1 && i == 1 && times[index + 1] == 0) {
                println("$index 추가")
                result++
            }
            if (acc == 1 && i == 0 && times[index + 1] == 0) {
                println("$index 추가")
                result++
            }
            if (index != 1 && acc == 0 && i == 0 && times[index + 1] == 2) {
                println("$index 추가")
                result++
            }


            println("$index : 이전 $acc, 현재 $i 다음 ${times[index + 1]}")
        }
        i
    }


    return result
}
