package com.xyyh.cloud.auth.server.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.xyyh.cloud.security.common.UserDetailsDto;

@FeignClient("UAP/users")
public interface UserClient {

	@GetMapping(params = "username")
	public UserDetailsDto loadUserByUsername(@RequestParam("username") String username);

	/**
	 * 校验用户的密码
	 * 
	 * @param user
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "valid", method = RequestMethod.POST)
	public boolean passwordCheck(@RequestParam("username") String username, @RequestParam("password") String password);
}
