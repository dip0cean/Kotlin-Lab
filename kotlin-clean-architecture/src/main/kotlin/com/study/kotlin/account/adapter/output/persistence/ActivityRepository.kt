package com.study.kotlin.account.adapter.output.persistence

import com.study.kotlin.account.adapter.output.entity.EActivity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
interface ActivityRepository : JpaRepository<EActivity, Long> {

    @Query("select a from EActivity a where a.ownerAccountId = :ownerAccountId and a.timeStamp >= :since")
    fun findByOwnerSince(
        @Param("ownerAccountId") ownerAccountId: Long,
        @Param("since") since: LocalDateTime = LocalDateTime.now()
    ): List<EActivity>

    @Query("select sum(a.amount) from EActivity a where a.targetAccountId = :accountId and a.ownerAccountId = :accountId and a.timeStamp < :until")
    fun getDepositBalanceUntil(
        @Param("accountId") accountId: Long,
        @Param("until") until: LocalDateTime = LocalDateTime.now()
    ): Long

    @Query("select sum(a.amount) from EActivity a where a.sourceAccountId = :accountId and a.ownerAccountId = :accountId and a.timeStamp < :until")
    fun getWithdrawalBalanceUntil(
        @Param("accountId") accountId: Long,
        @Param("until") until: LocalDateTime = LocalDateTime.now()
    ): Long
}
