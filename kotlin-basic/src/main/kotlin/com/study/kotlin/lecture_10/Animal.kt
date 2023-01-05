package com.study.kotlin.lecture_10

// 추상 클래스는 인스턴스화 할 수 없다.
abstract class Animal(
    protected val species: String,
    // Abstract Property 가 아닌 경우 open 키워드를 붙여야 하위 클래스에서 해당 Property 를 Override 할 수 있다.
    protected open val legCount: Int
) {
    abstract fun move()
}