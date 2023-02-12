package com.study.kotlin.extension

import io.kotest.property.Arb
import io.kotest.property.RandomSource
import io.kotest.property.arbitrary.Codepoint
import io.kotest.property.arbitrary.alphanumeric
import io.kotest.property.arbitrary.int
import io.kotest.property.arbitrary.long
import io.kotest.property.arbitrary.single
import io.kotest.property.arbitrary.string

fun Arb.Companion.id(): Long = this.long(1L..100000L).single(RandomSource.default())

fun Arb.Companion.name(): String =
    this.string(minSize = 1, maxSize = 20, codepoints = Codepoint.alphanumeric())
        .single(RandomSource.default())

fun Arb.Companion.age(): Int = this.int(1..100).single(RandomSource.default())
