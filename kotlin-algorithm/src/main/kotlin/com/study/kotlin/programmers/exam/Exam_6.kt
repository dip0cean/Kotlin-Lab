package com.study.kotlin.programmers.exam

fun main() {
//    val people = intArrayOf(1, 3, 3, 2, 4, 3, 3, 2, 4, 2, 2, 4)
    val people = intArrayOf(1, 1, 3, 3, 3, 3, 1, 3, 3, 3, 3, 2)
//    val people = intArrayOf(1, 2, 3, 4)
    solution(people)
}

private fun solution(people: IntArray) {
    val set = people.distinct().associateWith { 0 }.toMutableMap()
    println(set)

    val max = people.distinct().sorted().reversed().first()
    people.forEach { set[it] = set[it]!! + 1 }
    println(set)

    val map = set.filter { it.value != 0 }.entries.associate { it.key to it.value / 4 }
    println(map)

    val result = map.entries.filter { it.value > 0 }.flatMap { (1..it.value).map { _ -> it.key } }
        .takeIf { it.isNotEmpty() } ?: listOf(-1)
    println(result)

    result.toIntArray()
}
