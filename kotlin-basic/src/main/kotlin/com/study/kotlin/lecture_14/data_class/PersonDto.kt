package com.study.kotlin.lecture_14.data_class

fun main() {
    val person1 = PersonDto("심또익", 17)
    val person2 = PersonDto("심꼬망", 13)

    println(person1 == person2)
    println(person1)
}

// data 키워드를 붙여주면, equals / hashCode / toString 함수를 자동으로 만들어준다.
// 이 때, named argument 를 활용하면 Builder Pattern 으로도 사용할 수 있다.
// Java 에서는 JDK 16 부터 Record 라는 타입으로 만들 수 있다.
data class PersonDto(
    val name: String,
    val age: Int
)