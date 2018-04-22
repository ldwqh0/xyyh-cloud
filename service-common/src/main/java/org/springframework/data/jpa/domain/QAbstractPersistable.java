package org.springframework.data.jpa.domain;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.core.types.dsl.SimplePath;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.PathMetadata;
import static com.querydsl.core.types.PathMetadataFactory.*;

import javax.annotation.Generated;

/**
 * QAbstractPersistable is a Querydsl query type for AbstractPersistable
 */
@Generated("com.querydsl.codegen.SupertypeSerializer")
public class QAbstractPersistable extends EntityPathBase<AbstractPersistable<? extends java.io.Serializable>> {
	private static final long serialVersionUID = -544746190L;

	public static final QAbstractPersistable abstractPersistable = new QAbstractPersistable("abstractPersistable");

	public final SimplePath<java.io.Serializable> id = createSimple("id", java.io.Serializable.class);

	@SuppressWarnings({ "all", "rawtypes", "unchecked" })
	public QAbstractPersistable(String variable) {
		super((Class) AbstractPersistable.class, forVariable(variable));
	}

	@SuppressWarnings({ "all", "rawtypes", "unchecked" })
	public QAbstractPersistable(Path<? extends AbstractPersistable> path) {
		super((Class) path.getType(), path.getMetadata());
	}

	@SuppressWarnings({ "all", "rawtypes", "unchecked" })
	public QAbstractPersistable(PathMetadata metadata) {
		super((Class) AbstractPersistable.class, metadata);
	}
}
