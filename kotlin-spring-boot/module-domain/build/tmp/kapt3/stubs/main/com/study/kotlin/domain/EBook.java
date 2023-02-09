package com.study.kotlin.domain;

import java.lang.System;

@kotlin.Metadata(mv = {1, 8, 0}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\b\u0017\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0016\u0010\u0005\u001a\u00020\u00068\u0016X\u0097D\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0002\u001a\u00020\u00038\u0016X\u0097\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u000b"}, d2 = {"Lcom/study/kotlin/domain/EBook;", "", "name", "", "(Ljava/lang/String;)V", "id", "", "getId", "()J", "getName", "()Ljava/lang/String;", "module-domain"})
@jakarta.persistence.Table(name = "book")
@jakarta.persistence.Entity
public class EBook {
    @org.jetbrains.annotations.NotNull
    @jakarta.persistence.Column(name = "name", columnDefinition = "varchar", nullable = false)
    private final java.lang.String name = null;
    @jakarta.persistence.GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @jakarta.persistence.Id
    private final long id = 0L;
    
    public EBook(@org.jetbrains.annotations.NotNull
    java.lang.String name) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull
    public java.lang.String getName() {
        return null;
    }
    
    public long getId() {
        return 0L;
    }
}