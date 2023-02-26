package com.study.kotlin.account.application.port.output

interface AccountLock {

    fun lock(accountId: Long)

    fun release(accountId: Long)
}
