package com.study.kotlin.programmers.day_3

// https://school.programmers.co.kr/learn/courses/30/lessons/120812?language=kotlin
fun main() {
    val result = solution(1, 2, 3, 3, 3, 4)
    val resultCleanCode = solutionCleanCode(1, 2, 3, 3, 3, 4)
    println(result)
    println(resultCleanCode)
}

fun solutionCleanCode(vararg array: Int): Int {
    val list = array.groupBy { it }.entries.sortedByDescending { (_, value) -> value.size }
    return when {
        list.size > 1 && list[0].value.size == list[1].value.size -> -1
        else -> list[0].key
    }
}

fun solution(vararg array: Int): Int {
    val map = mutableMapOf<Int, Int>()
    array.forEach { index -> map.merge(index, 1, Int::plus) }
    val sortedMap = map.toList().sortedByDescending { (_, count) -> count }.toMap()
    val first = sortedMap.entries.first().value
    var count = 0

    for (entry in sortedMap.entries) {
        if (entry.value == first) {
            count++
        }
        if (count == 2) {
            return -1
        }
    }

    return sortedMap.entries.first().key
}
