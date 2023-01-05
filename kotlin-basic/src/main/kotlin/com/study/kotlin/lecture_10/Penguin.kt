package com.study.kotlin.lecture_10

class Penguin(
    species: String
) : Animal(species, 2), Swimable, Flyable {

    private val wing = 2

    override val legCount: Int
        get() = super.legCount + this.wing

    override fun move() {
        println("${this.species}는 이족보행이다.")
    }

    override fun flying() {
        throw IllegalStateException("펭귄은 날 수 없습니다!")
    }

    override fun swiming() {
        println("어푸~ 어푸~")
    }
}