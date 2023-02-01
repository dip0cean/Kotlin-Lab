package com.study.kotlin.account.domain

import com.study.kotlin.Mock
import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.mockk.every
import io.mockk.spyk
import io.mockk.verify

class ActivityWindowTest : ExpectSpec({

    context("현재 계좌 활동 창에서") {
        val activity = Mock.activity()
        val activityWindow = spyk(Mock.activityWindow(0..9))

        expect("새로운 이체 기록을 추가한다") {
            val activitiesSize = activityWindow.activities.size + 1
            activityWindow.addActivity(activity)
            activityWindow.activities.size shouldBe activitiesSize
            verify(exactly = 1) { activityWindow.addActivity(any()) }
        }

        expect("현재 잔고를 출력한다.") {
            every { activityWindow.calculateBalance(activity.id) } returns Money(1000L)
            val balance = activityWindow.calculateBalance(activity.id)
            balance.amount() shouldBe 1000L
            verify(exactly = 1) { activityWindow.calculateBalance(any()) }
        }
    }
})
