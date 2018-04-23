package com.xyyh.web.common.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.hibernate.annotations.Type;
import org.springframework.data.domain.Persistable;
import org.springframework.lang.Nullable;

@MappedSuperclass
public abstract class BasePersistable implements Persistable<UUID>, Serializable {

	private static final long serialVersionUID = -496832061973395035L;

	@Id
	@GeneratedValue
	@Type(type = "uuid-char")
	private @Nullable UUID id;

	public UUID getId() {
		return id;
	}

	protected void setId(UUID id) {
		this.id = id;
	}

	@Override
	public boolean isNew() {
		return Objects.isNull(id);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public String toString() {
		return "BasePersistable [id=" + id + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BasePersistable other = (BasePersistable) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
