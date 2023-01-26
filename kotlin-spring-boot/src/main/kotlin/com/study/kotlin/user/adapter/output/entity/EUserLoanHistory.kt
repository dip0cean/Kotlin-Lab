package com.study.kotlin.user.adapter.output.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_loan_history")
class EUserLoanHistory(
    @Column(name = "book_name", columnDefinition = "varchar", length = 255)
    val bookName: String = "",

    @Column(name = "returnable", columnDefinition = "boolean")
    val returnable: Boolean = false
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    val user: EUser = EUser()
}
