package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ServiceSimpleProviderUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSimpleProviderUserApplication.class, args);
	}

}
