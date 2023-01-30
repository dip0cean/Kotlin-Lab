package com.study.kotlin.account.application.port.output

import com.study.kotlin.account.domain.Account
import java.time.LocalDateTime

interface LoadAccountPort {

    fun loadAccount(accountId: Long, baselineDate: LocalDateTime): Account
}
