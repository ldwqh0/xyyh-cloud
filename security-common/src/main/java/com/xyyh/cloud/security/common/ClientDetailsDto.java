package com.xyyh.cloud.security.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.provider.ClientDetails;

public class ClientDetailsDto implements ClientDetails, Serializable {

	private static final long serialVersionUID = -7408160396122766317L;

	private String id;

	private String clientSecret;

	private Set<String> scope;

	private Set<String> authorizedGrantTypes;

	@Override
	public String getClientId() {
		return id;
	}

	@Override
	public Set<String> getResourceIds() {
		return null;
	}

	@Override
	public boolean isSecretRequired() {
		return true;
	}

	@Override
	public String getClientSecret() {
		return clientSecret;
	}

	@Override
	public boolean isScoped() {
		return true;
	}

	@Override
	public Set<String> getScope() {
		return scope;
	}

	@Override
	public Set<String> getAuthorizedGrantTypes() {
		return authorizedGrantTypes;
	}

	@Override
	public Set<String> getRegisteredRedirectUri() {

		return authorizedGrantTypes;
	}

	@Override
	public Collection<GrantedAuthority> getAuthorities() {
		return Collections.emptyList();
	}

	@Override
	public Integer getAccessTokenValiditySeconds() {
		return null;
	}

	@Override
	public Integer getRefreshTokenValiditySeconds() {
		return null;
	}

	@Override
	public boolean isAutoApprove(String scope) {
		return false;
	}

	@Override
	public Map<String, Object> getAdditionalInformation() {
		return null;
	}

}
