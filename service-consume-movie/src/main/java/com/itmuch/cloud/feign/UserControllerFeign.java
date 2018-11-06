package com.itmuch.cloud.feign;


import com.itmuch.cloud.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

/*
feign 常见问题总结:http://www.itmuch.com/spring-cloud-sum-feign/

添加configuration时 则自定义启用配置configuration的策略
feign 默认配置如下: 详情请看https://cloud.spring.io/spring-cloud-static/Edgware.SR5/single/spring-cloud.html#spring-cloud-feign-overriding-defaults
        Decoder feignDecoder: ResponseEntityDecoder (which wraps a SpringDecoder)
        Encoder feignEncoder: SpringEncoder
        Logger feignLogger: Slf4jLogger
        Contract feignContract: SpringMvcContract
        Feign.Builder feignBuilder: HystrixFeign.Builder
        Client feignClient: if Ribbon is enabled it is a LoadBalancerFeignClient, otherwise the default feign client is used.

同时要注意的是： 如果使用url属性 直接指定访问地址时，name一定要命名
Previously, using the url attribute, did not require the name attribute. Using name is now required.

@FeignClient(name = "service-provider-user",configuration = FeignConfiguration.class)*/
@FeignClient(name = "service-provider-user")
public interface UserControllerFeign {

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);


    @RequestMapping(value="/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public User getUser(User user);


    //写法一: GET方法   参数是复杂对象
    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id,
                        @RequestParam("username") String username,
                        @RequestParam("name") String name,
                        @RequestParam("age") Short age);

      //写法二: GET方法   参数是复杂对象
//    @RequestMapping(value = "/query-by", method = RequestMethod.GET)
//    public List<User> getUserByMap(@RequestParam Map<String, Object> param);


    /**
     *   @FeignClient(name = "service-provider-user",configuration = FeignConfiguration.class)
     *   当配置configuration为feign默认注解时  则不支持springmvc注解;
     *   需使用feign 默认注解  详情查看https://github.com/openfeign/feign
     */
//    @RequestLine("GET /simple/{id}")
//    public User findById(@Param("id") Long id);

}
