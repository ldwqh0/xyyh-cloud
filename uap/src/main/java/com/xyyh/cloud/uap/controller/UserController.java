package com.xyyh.cloud.uap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.cloud.security.common.UserDetailsDto;
import com.xyyh.cloud.security.common.UserDto;
import com.xyyh.cloud.uap.converter.UserConverter;
import com.xyyh.cloud.uap.entity.UserEntity;
import com.xyyh.cloud.uap.services.UserService;

import io.swagger.annotations.ApiOperation;

import static org.springframework.web.bind.annotation.RequestMethod.*;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	private UserService userSerivce;

	@Autowired
	private UserConverter userConverter;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@ApiOperation("获取用户信息")
	@GetMapping(params = "username")
	public UserDetailsDto loadByUserName(@RequestParam("userName") String username) {
		UserEntity userEntity = userSerivce.loadByUserName(username);
		return userConverter.toDetailsDto(userEntity);
	}

	/**
	 * 新增一条用户信息
	 * 
	 * @param user
	 * @return
	 */
	@RequestMapping(method = POST)
	public UserDto save(UserDto user) {
		UserEntity user_ = userSerivce.save(user);
		return userConverter.toDto(user_);
	}

	@ApiOperation("校验用户名和密码")
	@RequestMapping(value = "valid", method = POST)
	public boolean checkPassword(@RequestParam("username") String username, @RequestParam("password") String password) {
		UserEntity userEntity = userSerivce.loadByUserName(username);
		return passwordEncoder.matches(password, userEntity.getPassword());
	}

}
