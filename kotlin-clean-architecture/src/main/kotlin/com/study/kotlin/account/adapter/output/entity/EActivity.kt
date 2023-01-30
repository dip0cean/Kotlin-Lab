package com.study.kotlin.account.adapter.output.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import org.springframework.data.annotation.CreatedBy
import java.time.LocalDateTime

@Entity
@Table(name = "activity")
class EActivity(
    @Column(name = "owner_account_id", columnDefinition = "mediumint")
    val ownerAccountId: Long = 0L,
    @Column(name = "source_account_id", columnDefinition = "mediumint")
    val sourceAccountId: Long = 0L,
    @Column(name = "target_account_id", columnDefinition = "mediumint")
    val targetAccountId: Long = 0L,
    @Column(name = "amount", columnDefinition = "mediumint")
    val amount: Long = 0L
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @CreatedBy
    @Column(name = "time_stamp", columnDefinition = "timestamp")
    val timeStamp: LocalDateTime = LocalDateTime.now()
}
