package com.study.kotlin.lecture_10

class Cat(
    species: String
) : Animal(species, 4) {
    override fun move() {
        println("${this.species}는 사족보행이다.")
    }
}