package com.xyyh.cloud.uap.dto;

import java.io.Serializable;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class UserDto implements Serializable {

	private static final long serialVersionUID = -6533477124543130545L;

	private UUID id;

	private String username;

	private String password;

	private Boolean enabled;

	private Boolean credentialsExpired;

	private Boolean expired;

	private Boolean locked;
}
