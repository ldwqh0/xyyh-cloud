package com.xyyh.cloud.security.common;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
@JsonInclude(Include.NON_NULL)
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
