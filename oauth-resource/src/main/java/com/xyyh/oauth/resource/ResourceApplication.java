package com.xyyh.oauth.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
// @EnableEurekaClient pom里面如果启用了相应的Starter /可以不用这个注解
public class ResourceApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(ResourceApplication.class, args);
	}
}
