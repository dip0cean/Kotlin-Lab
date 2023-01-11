package com.study.kotlin.lecture_14.sealed_class

fun handleBrand(brand: Brand): String {
    return when (brand) {
        is Apple -> "아이폰 짱"
        is Google -> "구글이 세상을 지배한다!"
        is McDonald -> "1955 버거 JMT"
    }
}

sealed class Brand(
    val type: BrandType
)

enum class BrandType {
    IT, FOOD
}


class Apple : Brand(BrandType.IT)
class Google : Brand(BrandType.IT)
class McDonald : Brand(BrandType.FOOD)