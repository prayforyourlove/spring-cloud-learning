package com.itmuch.cloud;

import com.itmuch.cloud.config.ExcludeFromComponentScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableEurekaClient //注册eureka客户端
@EnableFeignClients //使用feign注解
@EnableCircuitBreaker//使用hystrix 注解
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})
public class ServiceSimpleConsumeMovieApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceSimpleConsumeMovieApplication.class, args);
	}

	/*@Bean
	@LoadBalanced  //ribbon负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}*/
}
