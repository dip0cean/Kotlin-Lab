package com.study.kotlin.lecture_14.enum_class

enum class Country(
    private val code: String
) {
    KOREA("ko"),
    US("us");

    companion object {
        fun handleCountry(country: Country): String {
            return when (country) {
                KOREA -> "이 곳은 한국입니다."
                US -> "이 곳은 미대륙입니다."
            }
        }
    }
}