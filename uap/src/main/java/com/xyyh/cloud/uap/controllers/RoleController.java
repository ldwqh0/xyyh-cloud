package com.xyyh.cloud.uap.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xyyh.cloud.security.common.RoleDto;
import com.xyyh.cloud.uap.converter.RoleConverter;
import com.xyyh.cloud.uap.entity.RoleEntity;
import com.xyyh.cloud.uap.services.RoleService;
 

@RestController
@RequestMapping("role")
public class RoleController {
	@Autowired
	private RoleService roleService;

 
	@Autowired
	private RoleConverter roleConverter;

	@RequestMapping(method = RequestMethod.POST)
	public RoleDto save(@ModelAttribute RoleDto roleDto) {
		try {
			RoleEntity roleEntity = roleService.save(roleDto);
			return roleConverter.toDto(roleEntity);
		} catch (Exception e) {
			return null;
		}
	}

 
}
