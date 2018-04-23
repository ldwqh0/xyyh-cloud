package com.xyyh.cloud.uap.services.support;

import java.util.UUID;

import javax.cache.annotation.CacheRemoveAll;
import javax.cache.annotation.CacheResult;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.xyyh.cloud.uap.converter.UserConverter;
import com.xyyh.cloud.uap.dto.UserDto;
import com.xyyh.cloud.uap.entity.UserEntity;
import com.xyyh.cloud.uap.repositories.UserRepository;
import com.xyyh.cloud.uap.services.UserService;

@Service
public class UserServiceSupport implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private UserConverter userConverter;

	@Override
	public UserEntity loadById(UUID id) {
		return userRepository.findById(id).get();
	}

	@Override
	@Transactional
	@CacheRemoveAll(cacheName = "user")
	public UserEntity save(UserDto user) {
		String password = user.getPassword();
		if (StringUtils.isBlank(password)) {
			password = "";
		}
		if (password.length() < 30) {
			password = passwordEncoder.encode(password);
		}
		UserEntity user_ = new UserEntity();
		userConverter.copyProperties(user_, user);
		user_.setPassword(password);
		user_ = userRepository.save(user_);
		return user_;
	}

	@Override
	@Transactional
	@CacheRemoveAll(cacheName = "user")
	public UserEntity update(UUID id, UserDto user) {
		UserEntity user_ = userRepository.findById(id).get();
		if (user_ != null) {
			userConverter.copyProperties(user_, user);
		}
		return user_;
	}

	@Override
	@CacheResult(cacheName = "user")
	public UserEntity loadByUserName(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public Page<UserEntity> findByUsername(String username, Pageable pageable) {
		return userRepository.findByUsernameContaining(username, pageable);
	}

	@Override
	@Transactional
	public void delete(UUID id) {
		userRepository.deleteById(id);
	}

}