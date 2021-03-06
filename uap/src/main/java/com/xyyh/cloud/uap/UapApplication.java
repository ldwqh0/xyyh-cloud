package com.xyyh.cloud.uap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
public class UapApplication {
	public static void main(String[] args) {
		SpringApplication.run(UapApplication.class);
	}
}
