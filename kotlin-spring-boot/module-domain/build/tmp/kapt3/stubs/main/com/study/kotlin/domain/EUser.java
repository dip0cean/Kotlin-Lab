package com.study.kotlin.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0017\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\t\u001a\u00020\n8\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u00108\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u0014"}, d2 = {"Lcom/study/kotlin/domain/EUser;", "", "name", "", "age", "", "(Ljava/lang/String;I)V", "getAge", "()I", "id", "", "getId", "()J", "getName", "()Ljava/lang/String;", "userLoanHistories", "", "Lcom/study/kotlin/domain/EUserLoanHistory;", "getUserLoanHistories", "()Ljava/util/List;", "module-domain"})
@jakarta.persistence.Table(name = "user")
@jakarta.persistence.Entity
public class EUser {
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(name = "name", columnDefinition = "varchar", nullable = false)
    private final java.lang.String name = null;
    @jakarta.persistence.Column(name = "age", columnDefinition = "int")
    private final int age = 0;
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.OneToMany(mappedBy = "user", cascade = {jakarta.persistence.CascadeType.ALL}, orphanRemoval = true)
    private final java.util.List<com.study.kotlin.domain.EUserLoanHistory> userLoanHistories = null;
    
    public EUser(@org.jetbrains.annotations.NotNull
    java.lang.String name, int age) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return null;
    }
    
    public int getAge() {
        return 0;
    }
    
    public long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public java.util.List<com.study.kotlin.domain.EUserLoanHistory> getUserLoanHistories() {
        return null;
    }
}