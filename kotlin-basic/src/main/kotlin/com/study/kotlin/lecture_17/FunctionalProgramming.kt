package com.study.kotlin.lecture_17

fun main() {
    val fruits = listOf(
        Fruit("사과", 1_000),
        Fruit("사과", 1_000),
        Fruit("사과", 1_000),
        Fruit("바나나", 2_500),
        Fruit("바나나", 2_500),
        Fruit("바나나", 2_500),
        Fruit("귤", 1_500),
        Fruit("귤", 1_500),
        Fruit("귤", 1_500),
        Fruit("멜론", 5_000),
        Fruit("두리안", 5_000),
        Fruit("두리안", 5_000),
    )

    // 람다를 만드는 방법 1
    val isApple = fun(fruit: Fruit): Boolean = fruit.name == "사과"
    // 람다를 만드는 방법 2
    val isBanana = { fruit: Fruit -> fruit.name == "바나나" }
    // 람다를 호출하는 방법 1
    isApple(fruits[0])
    // 람다를 호출하는 방법 2
    isBanana.invoke(fruits[1])

    // 람다 함수를 파라미터로 넣어주는 방법 1
    val onlyApples = filterFruits(fruits) { isApple(it) }
    // 람다 함수를 파라미터로 넣어주는 방법 2
    val onlyBananas = filterFruits(fruits, isBanana)
}

class Fruit(
    val name: String,
    val price: Int
)

private fun filterFruits(
    fruits: List<Fruit>, filter: (Fruit) -> Boolean
): List<Fruit> = fruits.filter(filter)
