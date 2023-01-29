package com.study.kotlin.programmers.day_2

// https://school.programmers.co.kr/learn/courses/30/lessons/120808
fun main() {
    val result = solution(1, 2, 3, 4)
    val resultCleanCode = solutionCleanCode(1, 2, 3, 4)
    println("분자 : ${result[0]}, 분모 : ${result[1]}")
    println("분자 : ${resultCleanCode[0]}, 분모 : ${resultCleanCode[1]}")
}

fun solutionCleanCode(
    numerator1: Int,
    denominator1: Int,
    numerator2: Int,
    denominator2: Int
): IntArray {
    // 최대 분자값
    val maxNumerator = (numerator1 * denominator2) + (numerator2 * denominator1)
    // 최대 분모값
    val maxDenominator = denominator1 * denominator2
    // 최소공약수
    val lowestDivisor =
        (1..maxDenominator)
            .filter { divisor -> maxNumerator % divisor == 0 && maxDenominator % divisor == 0 }
            .max()

    // [0] 기약 분수의 분자
    // [1] 기약 분수의 분모
    return intArrayOf(maxNumerator / lowestDivisor, maxDenominator / lowestDivisor)
}

fun solution(
    numerator1: Int,
    denominator1: Int,
    numerator2: Int,
    denominator2: Int
): IntArray {
    val array = when {
        // 분모 2 는 분모 1 의 배수인가?
        denominator1 > denominator2 -> when {
            denominator1 % denominator2 == 0 -> isMultiple(
                numerator1,
                denominator1,
                numerator2,
                denominator2
            )

            else -> isNotMultiple(numerator1, denominator1, numerator2, denominator2)
        }
        // 분모 1 은 분모 2 의 배수인가?
        denominator2 > denominator1 -> when {
            denominator2 % denominator1 == 0 -> isMultiple(
                numerator2,
                denominator2,
                numerator1,
                denominator1
            )

            else -> isNotMultiple(numerator2, denominator2, numerator1, denominator1)
        }
        // 분모 1 과 분모 2와 같다면
        else -> intArrayOf(numerator1 + numerator2, denominator1)
    }
    val gcd = gcd(array[0], array[1])
    return intArrayOf(array[0] / gcd, array[1] / gcd)
}

fun isMultiple(numerator1: Int, denominator1: Int, numerator2: Int, denominator2: Int): IntArray {
    val gap = denominator1 / denominator2
    val numerator = numerator1 + (numerator2 * gap)
    val denominator = denominator1
    return intArrayOf(numerator, denominator)
}

fun isNotMultiple(
    numerator1: Int,
    denominator1: Int,
    numerator2: Int,
    denominator2: Int
): IntArray {
    val numerator = (numerator1 * denominator2) + (numerator2 * denominator1)
    val denominator = denominator1 * denominator2
    return intArrayOf(numerator, denominator)
}

fun gcd(numerator: Int, demon: Int): Int =
    if (demon != 0) gcd(demon, numerator % demon) else numerator
