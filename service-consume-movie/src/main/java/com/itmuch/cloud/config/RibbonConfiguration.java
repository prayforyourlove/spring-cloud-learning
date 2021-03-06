package com.itmuch.cloud.config;


/**
 * ribbon 自定义策略 不可以被SpringBootApplication 包路径扫描到
 * 方式一 需在com.itmuch下设置一个包路径,不可在 com.itmuch.cloud路径下
 * 方式二 使用ExcludeFromComponentScan注解  通过ComponentScan excludeFilters排除扫描
 */
/*
@Configuration
@ExcludeFromComponentScan
// 代码编写自定义配置ribbon 策略
@RibbonClient(name = "service-provider-user",configuration = RibbonConfiguration.class)
public class RibbonConfiguration {

    @Bean
    public IRule ribbonRule(){
        return  new RandomRule();
    }
}
*/
