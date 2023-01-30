package com.study.kotlin.account.adapter.output.persistence

import com.study.kotlin.account.adapter.output.entity.EAccount
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface AccountRepository : JpaRepository<EAccount, Long>
