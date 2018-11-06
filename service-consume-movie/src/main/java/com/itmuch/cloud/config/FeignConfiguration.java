package com.itmuch.cloud.config;


/**
 * Feign 自定义策略 不可以被SpringBootApplication 包路径扫描到  否则则是对全局的Feign Client生效
 * 方式一 需在com.itmuch下设置一个包路径,不可在 com.itmuch.cloud路径下
 * 方式二 使用ExcludeFromComponentScan注解  通过ComponentScan excludeFilters排除扫描
 */
/*@Configuration
public class FeignConfiguration {


    *//**
     * 设置feign契约  使用feign 注解
     * 默认为 Contract feignContract: SpringMvcContract
     * @return
     *//*
    @Bean
    public Contract feignContract(){
        return new feign.Contract.Default();
    }


    *//**
     * 配置eureka 的用户名和密码  使@FeignClient中url属性无需自带用户名和密码
     * 如下
     * eureka.client.service-url.defaultZone: http://user:password@localhost:8761/eureka
     * @return
     *//*
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
        return new BasicAuthRequestInterceptor("user", "password");
    }
}*/
