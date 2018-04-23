package com.xyyh.cloud.uap.entity;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.xyyh.web.common.domain.BasePersistable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "role_")
public class RoleEntity extends BasePersistable {

	@Column(name = "name_", length = 50, nullable = false, unique = true)
	private String name;

	@Column(name = "description_", length = 4000)
	private String description;

	@Column(name = "authority_", length = 50, nullable = false, unique = true)
	private String authority;

	public String getAuthority() {
		return authority;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

}
