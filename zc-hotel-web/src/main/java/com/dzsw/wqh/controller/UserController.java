package com.dzsw.wqh.controller;


import com.dzsw.wqh.enumeration.ResultEnum;
import com.dzsw.wqh.model.UserEntity;
import com.dzsw.wqh.protocol.ResultResponse;
import com.dzsw.wqh.service.UserService;
import com.dzsw.wqh.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResultResponse regitster(@Validated @RequestBody UserEntity user) {
        log.info("注册用户请求参数:{}", JsonUtils.objectToJson(user));
        String userName = user.getUserName();
        UserEntity userEntity = userService.checkUserData(userName,null);
        if (userEntity.getId()!=null){
            return ResultResponse.buildResponse(ResultEnum.USER_REPEAT);
        }
        boolean register = userService.register(user);
        ResultResponse resultResponse;
        if(register){
            resultResponse=ResultResponse.buildResponse(ResultEnum.SUCCESS);
        }else {
            resultResponse=ResultResponse.buildResponse(ResultEnum.FAIL);
        }
        return resultResponse;
    }


    @PostMapping(value="/login")
    public ResultResponse login(@Validated @RequestBody UserEntity user) {

        log.info("登陆用户请求参数:{}", JsonUtils.objectToJson(user));
        String userName = user.getUserName();
        String passWord = user.getPassWord();
        UserEntity userEntity = userService.checkUserData(userName,passWord);
        ResultResponse resultResponse;
        if (userEntity.getId()==null){
            resultResponse=ResultResponse.buildResponse(ResultEnum.FAIL);
        }else {
            resultResponse=ResultResponse.buildResponse(ResultEnum.SUCCESS);
        }
        return resultResponse;
    }

}
