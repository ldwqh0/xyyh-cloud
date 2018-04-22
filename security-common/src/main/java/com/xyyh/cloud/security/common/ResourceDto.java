package com.xyyh.cloud.security.common;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * 资源数据传输对象
 * 
 * @author LiDong
 *
 */
@Data
public class ResourceDto implements Serializable {

	private static final long serialVersionUID = 6859447335992834215L;
	private Long id;
	private String url;
	private String method;

	private List<RoleDto> roles;

}
