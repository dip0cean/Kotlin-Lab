package com.study.kotlin.programmers.exam

fun main() {
    // 구간 별 요금
    val case1 = intArrayOf(200, 910, 93)
    val case2 = intArrayOf(400, 1600, 188)
    val case3 = intArrayOf(655, 7300, 281)
    val case4 = intArrayOf(0, 15372, 435)
    val case5 = intArrayOf(1851, 1000, 100)
    val case6 = intArrayOf(0, 2000, 155)
    val case7 = intArrayOf(100, 415, 90)
    val case8 = intArrayOf(250, 1600, 389)
    val case9 = intArrayOf(0, 7000, 480)

    // 전기요금 테이블
    val fees = arrayOf(
        case1, case2, case3, case4
//        case5, case6
//        case7, case8, case9
    )

    // 사용 전력량
    val usage = 320

    // 최종 청구금액 > 42,760원
    val fee = solution(fees, usage)

    println("$fee 원")
}

private fun solution(fees: Array<IntArray>, usage: Int): Int {
    val newFees =
        arrayOf(intArrayOf(0, fees[0][1], fees[0][2])) + fees

    var index = 0
    var basicFee = 0
    var sectionFee = 0

    newFees.reduce { current, next ->
        val beforeStandard = current[0]
        val nextStandard = next[0].takeIf { it != 0 } ?: (current[0] + 1)

        when {
            // 범위 안에 포함되는 경우
            usage in (beforeStandard + 1..nextStandard) -> {
                // 기본 요금 계산
                basicFee = next[1]
                // 현재 구간 사용료 계산
                sectionFee += (usage - beforeStandard) * next[2]
            }

            // 범위를 초과하는 경우
            nextStandard < usage -> {
                // 기본 요금 계산
                basicFee = next[1]
                // 현재 구간 사용료 계산
                when (index == fees.lastIndex) {
                    // 마지막 인덱스인 경우
                    true -> sectionFee += (usage - beforeStandard) * next[2]
                    // 마지막 인덱스가 아닌 경우
                    false -> {
                        val portion = usage / nextStandard
                        if (0 < portion) sectionFee += (nextStandard - beforeStandard) * next[2]
                    }
                }
            }
        }

        println("index : $index")
        println("beforeStandard : $beforeStandard")
        println("nextStandard : $nextStandard")
        println("basicFee : $basicFee")
        println("sectionFee : $sectionFee")
        println()

        if (index < fees.lastIndex) {
            index++
        }

        next
    }

    return basicFee + sectionFee
}
