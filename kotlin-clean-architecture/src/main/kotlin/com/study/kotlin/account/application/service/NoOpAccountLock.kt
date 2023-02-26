package com.study.kotlin.account.application.service

import com.study.kotlin.account.application.port.output.AccountLock
import org.springframework.stereotype.Component

@Component
class NoOpAccountLock : AccountLock {
    override fun lock(accountId: Long) {
        println("Lock $accountId")
    }

    override fun release(accountId: Long) {
        println("Release $accountId")
    }
}
