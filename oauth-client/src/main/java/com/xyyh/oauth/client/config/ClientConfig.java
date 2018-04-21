package com.xyyh.oauth.client.config;


import javax.annotation.PostConstruct;

import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;
import org.springframework.web.filter.OncePerRequestFilter;

@EnableWebSecurity
@EnableOAuth2Sso
public class ClientConfig extends WebSecurityConfigurerAdapter {
	// @Autowired
	// private AuthorizationCodeAccessTokenProvider tokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				.antMatchers("/login").permitAll()
				.anyRequest().authenticated();
		// http.csrf().csrfTokenRepository(csrfTokenRepository())
		// .and().addFilterAfter(csrfHeaderFilter(), CsrfFilter.class);
		http.csrf().disable();
		http.httpBasic().disable();
	}

	@PostConstruct
	public void test() {
		// System.out.println(template);
	}

	/**
	 * 使用这个Template访问资源
	 * 
	 * @param context
	 * @param details
	 * @return
	 */
	@Bean
	public OAuth2RestTemplate oauth2RestTemplate(OAuth2ClientContext context, OAuth2ProtectedResourceDetails details) {
		return new OAuth2RestTemplate(details, context);
	}

}
