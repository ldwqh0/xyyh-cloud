package com.xyyh.cloud.auth.server.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

@EnableResourceServer
@Configuration
@Order(99)
public class ResourceConfigurer extends ResourceServerConfigurerAdapter {

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		super.configure(resources);
		resources.tokenStore(tokenStore);
//		resources.authenticationEntryPoint(authenticationEntryPoint)
		// resources.tokenServices(tokenServices);
		// 如果使用jwt存储token的话，需要一个tokenExtractor将用户解析出来
		// resources.tokenExtractor(tokenExtractor);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		// http.csrf().disable();
		http.authorizeRequests().antMatchers("/**").authenticated();
		http.requestMatchers().antMatchers("/user**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
