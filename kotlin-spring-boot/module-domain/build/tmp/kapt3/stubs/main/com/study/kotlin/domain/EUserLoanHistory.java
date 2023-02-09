package com.study.kotlin.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0017\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\b\u0010\u0016\u001a\u00020\u0017H\u0016R\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0016\u0010\u000b\u001a\u00020\u00058\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0006\u001a\u00020\u00078\u0016@\u0016X\u0097\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0011\u001a\u00020\u00128\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0016\u0010\u0004\u001a\u00020\u00058\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r\u00a8\u0006\u0018"}, d2 = {"Lcom/study/kotlin/domain/EUserLoanHistory;", "", "bookName", "", "userId", "", "isReturn", "", "(Ljava/lang/String;JZ)V", "getBookName", "()Ljava/lang/String;", "id", "getId", "()J", "()Z", "setReturn", "(Z)V", "user", "Lcom/study/kotlin/domain/EUser;", "getUser", "()Lcom/study/kotlin/domain/EUser;", "getUserId", "doReturn", "", "module-domain"})
@jakarta.persistence.Table(name = "user_loan_history")
@jakarta.persistence.Entity
public class EUserLoanHistory {
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(name = "book_name", columnDefinition = "varchar")
    private final java.lang.String bookName = null;
    @jakarta.persistence.Column(name = "user_id", columnDefinition = "long")
    private final long userId = 0L;
    @jakarta.persistence.Column(name = "is_return", columnDefinition = "boolean")
    private boolean isReturn;
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.JoinColumn(name = "user_id")
    @jakarta.persistence.ManyToOne
    private final com.study.kotlin.domain.EUser user = null;
    
    public EUserLoanHistory(@org.jetbrains.annotations.NotNull
    java.lang.String bookName, long userId, boolean isReturn) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getBookName() {
        return null;
    }
    
    public long getUserId() {
        return 0L;
    }
    
    public boolean isReturn() {
        return false;
    }
    
    public void setReturn(boolean p0) {
    }
    
    public long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull
    public com.study.kotlin.domain.EUser getUser() {
        return null;
    }
    
    public void doReturn() {
    }
}