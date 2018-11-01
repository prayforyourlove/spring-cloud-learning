package com.itmuch.cloud.controller;

import com.itmuch.cloud.dao.UserDao;
import com.itmuch.cloud.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserDao userDao;

    @GetMapping("/simple/{id}")
    public User findById(@PathVariable Long id){
        return userDao.findOne(id);
    }
}
