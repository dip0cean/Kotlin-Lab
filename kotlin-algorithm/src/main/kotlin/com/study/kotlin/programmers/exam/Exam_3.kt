package com.study.kotlin.programmers.exam

val grades = listOf("GOLD", "SILVER", "BRONZE", "NORMAL")

fun main() {
    val gradeTable = arrayOf(
        intArrayOf(25000, 4), // GOLD
        intArrayOf(15000, 2), // SILVER
        intArrayOf(7000, 1) // BRONZE
    )

    val ledger = intArrayOf(30_000, -10_000, -7_000, 20_000)

    val result = solution(gradeTable, ledger)
    println(result)
}

private fun solution(gradeTable: Array<IntArray>, ledger: IntArray): String {
    // 평균 잔고액
    val average = average(ledger)
    println("average : $average")

    // 입금 횟수
    val depositCount = depositCount(ledger)
    println("depositCount : $depositCount")

    return grade(gradeTable, average, depositCount)
}

/**
 * 평균 잔고
 */
private fun average(ledger: IntArray): Int {
    val table = MutableList(ledger.size) { 0 }
    var balance = 0
    ledger.forEachIndexed { index, i ->
        balance += i
        table[index] = balance
    }

    return table.average().toInt()
}

/**
 * 입금 카운트
 */
private fun depositCount(ledger: IntArray): Int = ledger.count { it > 0 }

/**
 * 현재 등급과 다음 등급으로 승급 가능 조건
 */
private fun grade(gradeTable: Array<IntArray>, average: Int, depositCount: Int): String {
    // 현재 거래 내역을 기준으로 최고 등급 인덱스
    val minIndex =
        gradeTable.mapIndexed { index, i -> if (i[0] <= average && i[1] <= depositCount) index else gradeTable.size }
            .min()

    return when {
        // NORMAL 인 경우
        minIndex == gradeTable.size -> "${grades[grades.lastIndex]} ${gradeTable[gradeTable.lastIndex][0] - average} ${(gradeTable[gradeTable.lastIndex][1] - depositCount).takeIf { it > 0 } ?: 0}"
        // GOLD 인 경우
        grades[minIndex] == grades[0] -> grades[minIndex]
        // 나머지
        else -> "${grades[minIndex]} ${gradeTable[minIndex - 1][0] - average} ${gradeTable[minIndex - 1][1] - depositCount}"
    }
}
