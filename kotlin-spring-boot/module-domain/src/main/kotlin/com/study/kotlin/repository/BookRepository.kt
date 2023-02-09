package com.study.kotlin.repository

import com.study.kotlin.domain.EBook
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.querydsl.QuerydslPredicateExecutor
import org.springframework.stereotype.Repository

@Repository
interface BookRepository : JpaRepository<EBook, Long>, QuerydslPredicateExecutor<EBook>
