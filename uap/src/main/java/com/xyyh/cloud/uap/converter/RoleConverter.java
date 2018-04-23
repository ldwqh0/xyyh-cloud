package com.xyyh.cloud.uap.converter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Component;

import com.xyyh.cloud.security.common.GrantedAuthorityDto;
import com.xyyh.cloud.uap.dto.RoleDto;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.web.common.converter.AbstractConverter;

@Component
public class RoleConverter extends AbstractConverter<RoleEntity, RoleDto> {

	@Override
	public RoleDto toDtoActual(RoleEntity roleEntity) {
		RoleDto dto = new RoleDto();
		 dto.setId(roleEntity.getId());
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
			// dest.setId(source.getId());
			dest.setName(source.getName());
		}
	}

	public GrantedAuthorityDto toGrantedAuthorityDto(RoleEntity src) {
		return new GrantedAuthorityDto(src.getId().toString(), src.getAuthority());
	}

	public List<GrantedAuthorityDto> toGrantedAuthorityDto(Collection<RoleEntity> src) {
		if (CollectionUtils.isNotEmpty(src)) {
			List<GrantedAuthorityDto> dest = new ArrayList<>();
			for (RoleEntity _src : src) {
				dest.add(toGrantedAuthorityDto(_src));
			}
			return dest;
		} else {
			return Collections.emptyList();
		}
	}
}
