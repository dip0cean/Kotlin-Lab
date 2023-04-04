package com.study.kotlin.programmers.exam

fun main() {
    val n = 7
    val delivery = arrayOf(
        intArrayOf(5, 6, 0),
        intArrayOf(1, 3, 1),
        intArrayOf(1, 5, 0),
        intArrayOf(7, 6, 0),
        intArrayOf(3, 7, 1),
        intArrayOf(2, 5, 0)
    )
    val result = solution(n, delivery)
    println(result)
}

private fun solution(n: Int, delivery: Array<IntArray>): String {
    // 제품 별 재고 여부
    val inventoryStatus = MutableList(n + 1) { "?" }

    // 배송 완료된 주문의 제품은 재고가 있다.
    delivery.filter { it[2] == 1 }.forEach { (0..1).forEach { i -> inventoryStatus[it[i]] = "O" } }

    // 배송되지 않은 주문에 속한 제품 중 하나는 무조건 재고가 없다.
    delivery
        .filter { it[2] == 0 }
        .forEach {
            val anyStock = (0..1).any { i -> inventoryStatus[it[i]] == "O" }
            if (anyStock) {
                (0..1).filter { i -> inventoryStatus[it[i]] != "O" }
                    .forEach { i -> inventoryStatus[it[i]] = "X" }
            }
        }

    println(inventoryStatus)

    return (1..inventoryStatus.lastIndex).joinToString(separator = "") { inventoryStatus[it] }
}
