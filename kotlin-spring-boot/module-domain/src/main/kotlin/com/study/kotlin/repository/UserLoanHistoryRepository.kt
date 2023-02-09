package com.study.kotlin.repository

import com.study.kotlin.domain.EUserLoanHistory
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserLoanHistoryRepository :
    JpaRepository<EUserLoanHistory, Long>,
    QuerydslPredicateExecutor<EUserLoanHistory>
