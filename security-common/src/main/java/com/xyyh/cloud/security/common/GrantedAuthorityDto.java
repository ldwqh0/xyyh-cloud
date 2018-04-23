package com.xyyh.cloud.security.common;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.security.core.GrantedAuthority;

public class GrantedAuthorityDto implements Serializable, GrantedAuthority {

	private static final long serialVersionUID = 8900209882990597641L;
	private String id;

	private String role;

	public GrantedAuthorityDto(String id, String role) {
		this.id = id;
		this.role = role;
	}

	@Override
	public String getAuthority() {
		return role;
	}

	public String getId() {
		return id;
	}

	@Override
	public String toString() {
		return "GrantedAuthorityDto [id=" + id + ", role=" + role + "]";
	}
}
