package com.study.kotlin.user.application.command.input

data class UpdateUserCommand(
    val id: Long = 0L,
    val name: String = "",
    val age: Int = 0
)
