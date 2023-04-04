package com.study.kotlin.programmers.exam

fun main() {
    val result = solution(
        7,
        arrayOf(
            intArrayOf(5, 6, 0),
            intArrayOf(1, 3, 1),
            intArrayOf(1, 5, 0),
            intArrayOf(7, 6, 0),
            intArrayOf(3, 7, 1),
            intArrayOf(2, 5, 0)
        )
    )
    println(result)
}

private const val O = "O"
private const val X = "X"
private const val QUESTION_MARK = "?"

private fun solution(n: Int, delivery: Array<IntArray>): String {
    // 제품 별 재고 여부
    val warehousing = MutableList(n + 1) { _ -> QUESTION_MARK }

    // 배송 가능한 주문의 제품은 모두 재고가 있다. ( = O)
    delivery.filter { it[2] == 1 }.forEach { (0..1).forEach { i -> warehousing[it[i]] = O } }

    // 배송 불가능한 주문의 경우
    // 재고가 존재하는 제품을 포함하더라도 해당 주문에 속한 제품 모두 배송이 불가능하다.
    // 1. 주문에 포함된 제품 중 하나가 재고가 있는 경우, 나머지 제품은 재고가 없는 상태이다. ( = X)
    // 2. 주문에 포한된 제품 중 하나가 재고가 없는 경우, 나머지 제품은 재고를 알 수 없다. ( = ?)
    delivery.filter { it[2] == 0 }
        .forEach {
            when {
                (0..1).any { i -> warehousing[it[i]] == O } ->
                    (0..1)
                        .filter { i -> warehousing[it[i]] != O }
                        .forEach { i -> warehousing[it[i]] = X }
            }
        }
    return warehousing.joinToString(separator = "")
}
