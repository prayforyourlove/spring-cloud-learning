package com.itmuch.cloud.controller;

import com.itmuch.cloud.bean.User;
import com.itmuch.cloud.feign.UserControllerFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @Autowired
    private UserControllerFeign userControllerFeign;

  /*  @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://service-provider-user/simple/"+id,User.class);
    }*/

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
