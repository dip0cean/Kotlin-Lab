package com.study.kotlin.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QEBook is a Querydsl query type for EBook
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEBook extends EntityPathBase<EBook> {

    private static final long serialVersionUID = -770829025L;

    public static final QEBook eBook = new QEBook("eBook");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public QEBook(String variable) {
        super(EBook.class, forVariable(variable));
    }

    public QEBook(Path<? extends EBook> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEBook(PathMetadata metadata) {
        super(EBook.class, metadata);
    }

}

