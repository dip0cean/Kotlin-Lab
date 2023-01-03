package com.study.kotlin.lecture_07

import java.io.BufferedReader
import java.io.File
import java.io.FileReader

fun main() {
    // Checked Exception

    // UnChecked Exception

    // try with resources
}

fun parseIntOrThrow(str: String): Int {
    // try catch finally
    // try catch 구문 작성은 Java 와 동일하다.
    try {
        return str.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("주어진 문자열은 숫자가 아닙니다.")
    }
}

fun parseIntOrNull(str: String): Int? {
    // try catch 구문에서 Return 을 수행한다면 try catch 그대로 Return 이 가능하다.
    // 그 이유는 try catch 또한 하나의 Expression 이기 때문이다.
    return try {
        str.toInt()
    } catch (e: NumberFormatException) {
        null
    }
}

fun readFile() {
    // Checked Exception
    // Kotlin 에서는 Checked Exception 도 UnChecked Exception 으로 처리한다.
    val currentFile = File(".")
    val file = File("${currentFile.absolutePath}/a.txt")
    val reader = BufferedReader(FileReader(file))
    println(reader.readLine())
    reader.close()
}

fun readFile(path: String) {
    // Kotlin 에서는 try catch resources 구문이 존재하지 않는다.
    // use 라는 InLine 함수를 사용한다.
    BufferedReader(FileReader(path)).use { reader -> println(reader.readLine()) }

}