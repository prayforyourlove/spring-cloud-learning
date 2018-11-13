package com.itmuch.cloud.controller;

import com.itmuch.cloud.bean.User;
import com.itmuch.cloud.feign.UserControllerFeign;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class MovieController {

    @Autowired
    private UserControllerFeign userControllerFeign;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

  /*  @Autowired
    private RestTemplate restTemplate;

//        切换Hystrix以使用与调用者相同的线程
//        THREAD - 它在一个单独的线程上执行，并发请求受到线程池中线程数的限制
//        SEMAPHORE - 它在调用线程上执行，并发请求受信号量计数的限制
//        默认设置和建议设置是使用线程隔离（THREAD）
//        HystrixObservableCommands使用信号量隔离（SEMAPHORE）运行HystrixCommands。
//        文档: {@see <a href="https://github.com/Netflix/Hystrix/wiki/Configuration#execution.isolation.strategy"/>
//        默认配置:{@link com.netflix.hystrix.HystrixCommandProperties#default_executionIsolationStrategy}
//    @HystrixCommand(fallbackMethod = "stubMyService",
//            commandProperties = {
//              @HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")
//            })

    @GetMapping("/movie/{id}")
    @HystrixCommand(fallbackMethod = "findByIdByFallBack")
    public User findById(@PathVariable Long id){
        log.info("进入findById方法");
        return restTemplate.getForObject("http://service-provider-user/simple/"+id,User.class);
    }*/

    public User findByIdByFallBack(@PathVariable Long id){
        User user = new User();
        user.setId(0L);
        user.setName("用户不存在");
        log.info("进入findByIdByFallBack方法");
        return user;
    }

    @GetMapping("/test")
    public String test() {
        ServiceInstance serviceInstance = this.loadBalancerClient.choose("service-provider-user");
        System.out.println("111" + ":" + serviceInstance.getServiceId() + ":" + serviceInstance.getHost() + ":" + serviceInstance.getPort());
        return "1";
    }

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return userControllerFeign.findById(id);
    }

    @GetMapping("/test-post")
    public User testPost(User user) {
        return this.userControllerFeign.postUser(user);
    }

    @GetMapping("/test-get")
    public User testGet(User user) {
        return this.userControllerFeign.getUser(user.getId(), user.getUsername(), user.getName(), user.getAge());
    }

}
