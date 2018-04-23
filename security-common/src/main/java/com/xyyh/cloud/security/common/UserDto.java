package com.xyyh.cloud.security.common;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;

@Data
public class UserDto implements Serializable {
	private static final long serialVersionUID = 3365521438775743670L;

	private UUID id;

	private String username;

	private String password;

	private Boolean enabled;

	private Boolean credentialsExpired;

	private Boolean expired;

	private Boolean locked;

}
