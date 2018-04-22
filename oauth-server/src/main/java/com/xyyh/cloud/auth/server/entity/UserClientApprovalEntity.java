package com.xyyh.cloud.auth.server.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;

import lombok.Getter;
import lombok.Setter;

/**
 * 用户授权信息
 * 
 * @author LiDong
 *
 */
@Entity(name = "user_client_approval_")
@Getter
@Setter
/*
 * @Table(name = "user_client_approval_", uniqueConstraints = {
 * 
 * @UniqueConstraint(columnNames = { "user", "client" }) })
 */
@IdClass(UserClientApprovalEntity.class)
public class UserClientApprovalEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1307741254102004177L;

	@Id
	@Column(name = "user_", length = 250)
	private String user;

	@Id
	@Column(name = "client_", length = 250)
	private String client;

}
