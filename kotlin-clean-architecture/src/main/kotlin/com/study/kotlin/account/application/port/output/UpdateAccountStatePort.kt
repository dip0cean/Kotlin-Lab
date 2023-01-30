package com.study.kotlin.account.application.port.output

import com.study.kotlin.account.domain.Account

interface UpdateAccountStatePort {

    fun updateActivities(account: Account)
}
