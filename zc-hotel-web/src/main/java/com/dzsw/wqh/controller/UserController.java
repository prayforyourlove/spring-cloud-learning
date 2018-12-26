package com.dzsw.wqh.controller;


import com.dzsw.wqh.model.UserEntity;
import com.dzsw.wqh.service.UserService;
import com.dzsw.wqh.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(value="/register")
    public String regitster(Model model,@Validated @RequestBody UserEntity user) {
        log.info("注册用户请求参数:{}", JsonUtils.objectToJson(user));
        String userName = user.getUserName();
        UserEntity userEntity = userService.checkUserData(userName,null);
        if (userEntity.getId()!=null){
            model.addAttribute("result","用户已注册");
            return "login";
        }
        boolean register = userService.register(user);
        if(register){
            model.addAttribute("result","注册成功,请登陆");
           return "login";
        }
        model.addAttribute("result","注册失败,请重新注册");
        return "register";
    }


    @PostMapping(value="/login")
    public String login(Model model, @Validated @RequestBody UserEntity user) {

        log.info("登陆用户请求参数:{}", JsonUtils.objectToJson(user));
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        UserEntity userEntity = userService.checkUserData(userName,passWord);
        if (userEntity.getId()==null){
            return "register";
        }
        model.addAttribute("user",userEntity);
        return "index";

    }

}
