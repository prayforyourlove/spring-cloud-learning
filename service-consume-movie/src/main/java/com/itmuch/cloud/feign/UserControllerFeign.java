package com.itmuch.cloud.feign;


import com.itmuch.cloud.bean.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "service-provider-user")
public interface UserControllerFeign {

    // 两个坑：1. @GetMapping不支持   2. @PathVariable得设置value
    @RequestMapping(value = "/simple/{id}",method = RequestMethod.GET)
    public User findById(@PathVariable("id") Long id);


    @RequestMapping(value="/user",method = RequestMethod.POST)
    public User postUser(@RequestBody User user);

    // 该请求不会成功，只要参数是复杂对象，即使指定了是GET方法，feign依然会以POST方法进行发送请求。
/*    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public User getUser(User user);*/

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public User getUser(@RequestParam("id") Long id,
                        @RequestParam("username") String username,
                        @RequestParam("name") String name,
                        @RequestParam("age") Short age);

}
