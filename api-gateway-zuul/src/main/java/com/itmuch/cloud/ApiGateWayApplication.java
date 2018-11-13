package com.itmuch.cloud;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
public class ApiGateWayApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiGateWayApplication.class, args);
    }


    /**
     * This means that a serviceId "myusers-v1" will be mapped to route "/v1/myusers/**"
     * In the example above, a serviceId "myusers" will be mapped to route "/myusers/**" (no version detected)
     * {@see <a href="https://cloud.spring.io/spring-cloud-static/Edgware.SR5/single/spring-cloud.html#netflix-zuul-reverse-proxy"/>
     * @return
     */
    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }
}
