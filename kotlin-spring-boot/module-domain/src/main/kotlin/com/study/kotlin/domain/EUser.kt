package com.study.kotlin.domain

import jakarta.persistence.CascadeType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table

@Entity
@Table(name = "user")
class EUser(
    @Column(name = "name", columnDefinition = "varchar", nullable = false)
    val name: String,

    @Column(name = "age", columnDefinition = "int")
    val age: Int
) {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "tinyint")
    val id: Long = 0L

    @OneToMany(mappedBy = "user", cascade = [CascadeType.ALL], orphanRemoval = true)
    val userLoanHistories: MutableList<EUserLoanHistory> = mutableListOf()
}
