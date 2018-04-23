package com.xyyh.cloud.uap.converter;

import org.springframework.stereotype.Component;

import com.xyyh.cloud.security.common.RoleDto;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.web.common.converter.AbstractConverter;

@Component
public class RoleConverter extends AbstractConverter<RoleEntity, RoleDto> {

	@Override
	public RoleDto toDtoActual(RoleEntity roleEntity) {
		RoleDto dto = new RoleDto();
//		dto.setId(roleEntity.getId());
		dto.setName(roleEntity.getName());
		dto.setDescription(roleEntity.getDescription());
		dto.setAuthority(roleEntity.getAuthority());
		return dto;
	}

	@Override
	public void copyProperties(RoleEntity dest, RoleDto source) {
		if (dest != null && source != null) {
			dest.setAuthority(source.getAuthority());
			dest.setDescription(source.getDescription());
//			dest.setId(source.getId());
			dest.setName(source.getName());
		}
	}
}
