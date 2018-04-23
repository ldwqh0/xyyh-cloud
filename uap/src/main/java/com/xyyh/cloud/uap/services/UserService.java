package com.xyyh.cloud.uap.services;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.xyyh.cloud.uap.dto.UserDto;
import com.xyyh.cloud.uap.entity.UserEntity;

public interface UserService {
	/**
	 * 根据用户ID获取用户信息
	 * 
	 * @param id
	 * @return
	 */
	public UserEntity loadById(UUID id);

	/**
	 * 保存用户信息，包括密码信息
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity save(UserDto user);

	/**
	 * 更新用户信息，但不会更新密码信息
	 * 
	 * @param user
	 * @return
	 */
	public UserEntity update(UUID id, UserDto user);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param userName
	 * @return
	 */
	public UserEntity loadByUserName(String userName);

	/**
	 * 根据用户名模糊查询用户列表
	 * 
	 * @param username
	 *            模糊用户名
	 * @param pageRequest
	 *            分页请求
	 * @return
	 */
	public Page<UserEntity> findByUsername(String username, Pageable pageRequest);

	/**
	 * 删除用户
	 * 
	 * @param id
	 */
	public void delete(UUID id);

}
