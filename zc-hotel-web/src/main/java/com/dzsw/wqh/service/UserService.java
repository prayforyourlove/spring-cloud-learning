package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.UserEntityMapper;
import com.dzsw.wqh.model.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.weekend.Weekend;
import tk.mybatis.mapper.weekend.WeekendCriteria;

import java.util.ArrayList;
import java.util.Date;
import java.util.Optional;

@Service()
public class UserService {

    @Autowired
    private UserEntityMapper userEntityMapper;

    public boolean register(UserEntity user) {
        user.setInsertTime(new Date());
        int i = userEntityMapper.insertUseGeneratedKeys(user);
        return i>0;
    }

    public UserEntity checkUserData(String userName,String passWord) {
        if (StringUtils.isEmpty(userName)) {
            return new UserEntity();
        }
        Weekend<UserEntity> weekend = Weekend.of(UserEntity.class);
        WeekendCriteria<UserEntity, Object> criteria = weekend
                .weekendCriteria();
        criteria.andEqualTo(UserEntity::getUserName,userName);
        if (!StringUtils.isEmpty(passWord)){
            criteria.andEqualTo(UserEntity::getPassWord,passWord);
        }
        UserEntity userEntity = userEntityMapper.selectOneByExample(weekend);
        return Optional.ofNullable(userEntity).orElseGet(UserEntity::new);

    }
}
