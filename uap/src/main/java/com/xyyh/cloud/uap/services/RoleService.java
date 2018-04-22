package com.xyyh.cloud.uap.services;

import com.xyyh.cloud.security.common.RoleDto;
import com.xyyh.cloud.uap.entity.RoleEntity;

public interface RoleService {
	public RoleEntity save(RoleDto role);
}
