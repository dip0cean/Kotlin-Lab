package com.study.kotlin.account.domain

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.mockk.mockk
import io.mockk.spyk
import io.mockk.verify

class ActivityWindowTest : ExpectSpec({

    val activity = mockk<Activity>(relaxed = true)
    val activityWindow = spyk(ActivityWindow(mutableListOf(activity)))

    context("현재 계좌 활동 창에서") {
        expect("새로운 이체 기록을 추가한다") {
            activityWindow.addActivity(activity)
            verify(exactly = 1) { activityWindow.addActivity(any()) }
        }

        expect("현재 잔고를 출력한다.") {
            val balance = activityWindow.calculateBalance(activity.id)
            balance.amount() shouldBe activity.money.amount()
            verify(exactly = 1) { activityWindow.calculateBalance(any()) }
        }
    }
})
