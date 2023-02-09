package com.study.kotlin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEUser is a Querydsl query type for EUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEUser extends EntityPathBase<EUser> {

    private static final long serialVersionUID = -770259455L;

    public static final QEUser eUser = new QEUser("eUser");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final ListPath<EUserLoanHistory, QEUserLoanHistory> userLoanHistories = this.<EUserLoanHistory, QEUserLoanHistory>createList("userLoanHistories", EUserLoanHistory.class, QEUserLoanHistory.class, PathInits.DIRECT2);

    public QEUser(String variable) {
        super(EUser.class, forVariable(variable));
    }

    public QEUser(Path<? extends EUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEUser(PathMetadata metadata) {
        super(EUser.class, metadata);
    }

}

