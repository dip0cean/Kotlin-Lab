package com.study.kotlin.account.adapter.output.persistence

import com.study.kotlin.account.application.port.output.LoadAccountPort
import com.study.kotlin.account.application.port.output.UpdateAccountStatePort
import com.study.kotlin.common.PersistenceAdapter

@PersistenceAdapter
private class AccountPersistenceAdapter(
    private val accountRepository: AccountRepository
) : LoadAccountPort, UpdateAccountStatePort
