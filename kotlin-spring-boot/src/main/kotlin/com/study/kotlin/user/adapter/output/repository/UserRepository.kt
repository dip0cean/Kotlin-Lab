package com.study.kotlin.user.adapter.output.repository

import com.study.kotlin.user.adapter.output.entity.EUser
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<EUser, Long>
