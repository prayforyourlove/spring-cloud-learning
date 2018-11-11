package com.itmuch.cloud.feign;

import com.itmuch.cloud.bean.User;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UserControllerFeignFallbackFactory implements FallbackFactory<UserControllerFeign> {

    @Override
    public UserControllerFeign create(Throwable throwable) {
        //可以拦截异常
        log.info("拦截异常为:{}",throwable.getMessage());
        return new  UserControllerFeign(){
            @Override
            public User findById(Long id) {
                User user = new User();
                user.setId(-1L);
                user.setName("factory用户不存在");
                log.info("进入feignFallBackFactory方法");
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
        };
    }
}
