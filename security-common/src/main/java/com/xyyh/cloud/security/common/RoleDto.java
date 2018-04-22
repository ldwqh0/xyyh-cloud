package com.xyyh.cloud.security.common;

import java.io.Serializable;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

/**
 * 角色数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
public class RoleDto implements Serializable, GrantedAuthority {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String authority;
	private String name;
	private String description;

	@Override
	public String getAuthority() {
		return authority;
	}

}
