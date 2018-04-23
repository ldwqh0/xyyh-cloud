package com.xyyh.cloud.uap.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.cloud.uap.converter.RoleConverter;
import com.xyyh.cloud.uap.dto.RoleDto;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.cloud.uap.services.RoleService;

@RestController
@RequestMapping("roles")
public class RoleController {
	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleConverter roleConverter;

	@PostMapping
	public RoleDto save(@RequestBody RoleDto roleDto) {
		RoleEntity roleEntity = roleService.save(roleDto);
		return roleConverter.toDto(roleEntity);
	}

}
