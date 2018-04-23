package com.xyyh.cloud.gateway.config;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
@EnableOAuth2Sso
public class OAuthClientConfigure extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/client/login**").permitAll()
				.anyRequest().authenticated();
		http.csrf().disable();
		http.httpBasic().disable();
//		http.requestMatchers().antMatchers("/test/**", "/client/**");
	}
}
