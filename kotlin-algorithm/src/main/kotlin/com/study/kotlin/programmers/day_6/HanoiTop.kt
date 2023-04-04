package com.study.kotlin.programmers.day_6

fun main() {

}

private fun solution(n: Int): Array<IntArray> {
    val tops = (1..3).associate { it to Top(n) }
    return arrayOf(intArrayOf())
}

class Top(size: Int) {
    private val stack = IntArray(size)

    fun push(negative: Int): Int {
        var index = 0
        stack.reduceIndexed { i, acc, curr ->
            curr
        }
        return negative
    }

    fun pop(): Int {
        return 0
    }

    fun peek(): Int {
        return 0
    }
}
