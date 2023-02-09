package com.study.kotlin.domain

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table

@Entity
@Table(name = "user_loan_history")
class EUserLoanHistory(
    @Column(name = "book_name", columnDefinition = "varchar")
    val bookName: String,

    @Column(name = "user_id", columnDefinition = "long")
    val userId: Long,

    @Column(name = "is_return", columnDefinition = "boolean")
    var isReturn: Boolean
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L

    @ManyToOne
    @JoinColumn(name = "user_id")
    val user: EUser = EUser("", 0)

    fun doReturn() {
        this.isReturn = true
    }
}
