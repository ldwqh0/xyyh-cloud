package com.xyyh.cloud.uap.converter;

import java.util.List;
import java.util.Objects;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.xyyh.cloud.security.common.UserDetailsDto;
import com.xyyh.cloud.security.common.UserDto;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.cloud.uap.entity.UserEntity;
import com.xyyh.web.common.converter.AbstractConverter;

@Component
public class UserConverter extends AbstractConverter<UserEntity, UserDto> {

	@Autowired
	private RoleConverter roleConverter;

	@Override
	public UserDto toDtoActual(final UserEntity entity) {
		final UserDto dto = new UserDto();
		 dto.setCredentialsExpired(entity.isCredentialsExpired());
		 dto.setEnabled(entity.isEnabled());
		 dto.setExpired(entity.isExpired());
		 dto.setId(entity.getId());
		 dto.setLocked(entity.isLocked());
		 dto.setUsername(entity.getUsername());
		return dto;
	}

	/**
	 * 从数据传输对象复制用户的属性到实体对象<br />
	 * 不会复制ID和密码属性
	 */
	@Override
	public void copyProperties(final UserEntity dest, final UserDto source) {
		if (!Objects.isNull(source) && !Objects.isNull(dest)) {
			dest.setCredentialsExpired(BooleanUtils.toBoolean(source.getCredentialsExpired()));
			dest.setEnabled(BooleanUtils.toBoolean(source.getEnabled()));
			dest.setExpired(BooleanUtils.toBoolean(source.getExpired()));
			dest.setLocked(BooleanUtils.toBoolean(source.getLocked()));
			dest.setUsername(source.getUsername());
		}
	}

	/**
	 * 复制数据到DTO，不会复制密码信息
	 * 
	 * @param from
	 * @param dest
	 */
	public UserDetailsDto toDetailsDto(UserEntity from) {
		UserDetailsDto dest = new UserDetailsDto();
		dest.setCredentialsExpired(from.isCredentialsExpired());
		dest.setEnabled(from.isEnabled());
		dest.setExpired(from.isExpired());
		dest.setLocked(from.isLocked());
		dest.setUsername(from.getUsername());
		dest.setId(from.getId());
		List<RoleEntity> roleEntities = from.getRoleEntities();
		if (CollectionUtils.isNotEmpty(roleEntities)) {
			dest.setAuthorities(roleConverter.toDto(roleEntities));
		}
		return dest;
	}
}
