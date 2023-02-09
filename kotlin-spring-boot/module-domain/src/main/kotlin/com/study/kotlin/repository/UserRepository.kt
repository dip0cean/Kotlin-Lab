package com.study.kotlin.repository

import com.study.kotlin.domain.EUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<EUser, Long>, QuerydslPredicateExecutor<EUser>
