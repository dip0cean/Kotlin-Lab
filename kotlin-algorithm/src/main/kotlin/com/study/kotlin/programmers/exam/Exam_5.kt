package com.study.kotlin.programmers.exam

fun main() {
    val ings = arrayOf("r 10", "a 23", "t 124", "k 9")
    val menu = arrayOf(
        "PIZZA arraak 145",
        "HAMBURGER tkar 180",
        "BREAD kkk 30",
        "ICECREAM rar 50",
        "SHAVEDICE rar 45",
        "JUICE rra 55",
        "WATER a 20"
    )
    val sell = arrayOf("BREAD 5", "ICECREAM 100", "PIZZA 7", "JUICE 10", "WATER 1")
    solution(ings, menu, sell)
}

private fun solution(ings: Array<String>, menu: Array<String>, sell: Array<String>) {
    val replaceIngs = ings.map { it.split(" ") }.associate { it[0] to it[1] }
    val replaceMenu = menu.map { it.split(" ") }

    replaceMenu.forEach { println(it) }
    println()

    val material = replaceMenu.associate { it[0] to it[1].split("").associateWith { 0 }.toMutableMap() }

//    material.entries.forEach {
//        replaceMenu.forEach { m ->
//            m[1].split("").forEach { str ->
//                if (replaceIngs[str] != null && material[it.key]!![str] != null) {
//                    println(str)
//                    material[it.key]!![str] = material[it.key]!![str]!! + 1
//                }
//            }
//        }
//    }
    material.forEach {
        it.value.forEach { entry ->

        }
    }

    material.forEach { println("${it.key} : ${it.value}") }
}
