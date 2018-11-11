package com.itmuch.cloud.feign;

import com.itmuch.cloud.bean.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


/**
 * feign 的hystrix的fallback类
 */
@Component
@Slf4j
public class UserControllerFeignFallback implements UserControllerFeign {

    @Override
    public User findById(Long id) {
        User user = new User();
        user.setId(0L);
        user.setName("用户不存在");
        log.info("进入feignFallBack方法");
        return user;
    }

    @Override
    public User postUser(User user) {
        return null;
    }

    @Override
    public User getUser(User user) {
        return null;
    }

    @Override
    public User getUser(Long id, String username, String name, Short age) {
        return null;
    }
}