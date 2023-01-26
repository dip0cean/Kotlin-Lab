package com.study.kotlin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class LibraryApplication

fun main(args: Array<String>) {
    runApplication<LibraryApplication>(*args)
}
