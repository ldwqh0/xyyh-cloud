package com.xyyh.cloud.uap.services.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.cloud.security.common.RoleDto;
import com.xyyh.cloud.uap.converter.RoleConverter;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.cloud.uap.repositories.RoleRepository;
import com.xyyh.cloud.uap.services.RoleService;

@Service
public class RoleServiceSupport implements RoleService {
	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private RoleConverter roleConverter;

	@Override
	@Transactional
	public RoleEntity save(RoleDto roleDto) {
		RoleEntity roleEntity = new RoleEntity();
		roleConverter.copyProperties(roleEntity, roleDto);
		roleEntity = roleRepository.save(roleEntity);
		return roleEntity;
	}

}
