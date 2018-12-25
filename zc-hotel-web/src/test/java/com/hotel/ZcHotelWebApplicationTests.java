package com.hotel;

import com.dzsw.wqh.ZcHotelWebApplication;
import com.dzsw.wqh.mapper.UserEntityMapper;
import com.dzsw.wqh.model.UserEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ZcHotelWebApplication.class)
public class ZcHotelWebApplicationTests {

    @Autowired
    private UserEntityMapper userEntityMapper;

    @Test
    @Rollback(value=false)
    public void contextLoads() {
        UserEntity user=new UserEntity();
        user.setUserName("小米");
        user.setPassWord("123456");
        user.setMobile("13616540380");
        user.setSex("00");
        user.setAge(2);
        user.setEmail("11111");

        int insert = userEntityMapper.insert(user);
        System.out.println(insert);
    }

}

