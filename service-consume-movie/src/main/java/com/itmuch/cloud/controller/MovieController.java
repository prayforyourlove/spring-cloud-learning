package com.itmuch.cloud.controller;

import com.itmuch.cloud.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MovieController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/movie/{id}")
    public User findById(@PathVariable Long id){
        return restTemplate.getForObject("http://localhost:880/simple/"+id,User.class);
    }

}
