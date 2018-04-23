package com.xyyh.web.common.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import javax.annotation.Generated;

import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import com.querydsl.core.types.dsl.ComparablePath;
import com.querydsl.core.types.dsl.EntityPathBase;

@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QBasePersistable extends EntityPathBase<BasePersistable> {
	private static final long serialVersionUID = -2018509754L;

	public static final QBasePersistable basePersistable = new QBasePersistable("basePersistable");

	public final ComparablePath<java.util.UUID> id = createComparable("id", java.util.UUID.class);

	public QBasePersistable(String variable) {
		super(BasePersistable.class, forVariable(variable));
	}

	public QBasePersistable(Path<? extends BasePersistable> path) {
		super(path.getType(), path.getMetadata());
	}

	public QBasePersistable(PathMetadata metadata) {
		super(BasePersistable.class, metadata);
	}
}
