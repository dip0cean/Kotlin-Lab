package com.study.kotlin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEUserLoanHistory is a Querydsl query type for EUserLoanHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEUserLoanHistory extends EntityPathBase<EUserLoanHistory> {

    private static final long serialVersionUID = 480776387L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEUserLoanHistory eUserLoanHistory = new QEUserLoanHistory("eUserLoanHistory");

    public final StringPath bookName = createString("bookName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isReturn = createBoolean("isReturn");

    public final QEUser user;

    public final NumberPath<Long> userId = createNumber("userId", Long.class);

    public QEUserLoanHistory(String variable) {
        this(EUserLoanHistory.class, forVariable(variable), INITS);
    }

    public QEUserLoanHistory(Path<? extends EUserLoanHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEUserLoanHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEUserLoanHistory(PathMetadata metadata, PathInits inits) {
        this(EUserLoanHistory.class, metadata, inits);
    }

    public QEUserLoanHistory(Class<? extends EUserLoanHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new QEUser(forProperty("user")) : null;
    }

}

