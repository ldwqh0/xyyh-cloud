package com.xyyh.cloud.uap.dto;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

/**
 * 角色数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
public class RoleDto implements Serializable {
	private static final long serialVersionUID = 1L;
	private UUID id;
	private String authority;
	private String name;
	private String description;

}
