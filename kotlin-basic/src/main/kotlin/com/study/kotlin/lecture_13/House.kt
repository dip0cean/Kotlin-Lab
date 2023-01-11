package com.study.kotlin.lecture_13

class House(
    val address: String,
    val livingRoom: LivingRoom,
    val bathRoom: BathRoom
) {

    // static 중첩 클래스
    class LivingRoom(
        private val area: Double
    )

    // 외부에서 접근 가능한 내부 클래스
    inner class BathRoom(
        private val area: Double
    ) {
        // 바깥 클래스를 참조하기 위한 방법
        val address: String
            get() = this@House.address
    }
}