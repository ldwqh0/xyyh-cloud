package com.xyyh.cloud.uap.entity;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import org.springframework.data.jpa.domain.AbstractPersistable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "user_")
public class UserEntity extends AbstractPersistable<String> implements Serializable {

	private static final long serialVersionUID = -532240698999268985L;

	@Column(name = "username_", length = 50, unique = true, nullable = false)
	private String username;

	@Column(name = "password_", length = 128)
	private String password;

	@Column(name = "enabled_")
	private boolean enabled;

	@Column(name = "credentials_expired_")
	private boolean credentialsExpired;

	@Column(name = "expired_")
	private boolean expired;

	@Column(name = "locked_")
	private boolean locked;

	/**
	 * 用户的角色
	 */
	@ManyToMany(cascade = CascadeType.REFRESH, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role_", joinColumns = {
			@JoinColumn(name = "user_", referencedColumnName = "id_") }, inverseJoinColumns = {
					@JoinColumn(name = "role_", referencedColumnName = "id_") })
	private List<RoleEntity> roleEntities;

	/**
	 * 用户授权的client
	 */
	@ManyToMany
	private List<ClientDetailsEntity> approvalClients;

	public UserEntity() {
		this.setId(UUID.randomUUID().toString());
	}

}
