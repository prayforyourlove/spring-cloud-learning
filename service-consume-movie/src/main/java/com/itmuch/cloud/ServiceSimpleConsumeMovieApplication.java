package com.itmuch.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
// 代码编写自定义配置ribbon 策略
/*@RibbonClient(name = "service-provider-user",configuration = RibbonConfiguration.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,value = ExcludeFromComponentScan.class)})*/
@EnableFeignClients
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
