package com.xyyh.cloud.uap.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;

import com.xyyh.web.common.domain.BasePersistable;

import lombok.Getter;
import lombok.Setter;

@Entity(name = "client_info_")
@Getter
@Setter
public class ClientDetailsEntity extends BasePersistable {

	/**
	 * 连接的密钥，密钥是加密的
	 */
	@Column(name = "client_secret_")
	private String clientSecret;

	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> scope;

	/**
	 * 授权类型
	 */
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> authorizedGrantTypes;

}
