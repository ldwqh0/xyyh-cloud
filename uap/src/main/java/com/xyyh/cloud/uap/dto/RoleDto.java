package com.xyyh.cloud.uap.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

/**
 * 角色数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
@JsonInclude(Include.NON_NULL)
public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String authority;
	private String name;
	private String description;

}
