package com.study.kotlin.user.domain

data class User(
    val id: Long = 0L,
    var name: String = "",
    var age: Int = 0
) {

    fun update(name: String?, age: Int?) {
        this.name = name ?: this.name
        this.age = age ?: this.age
    }
}
