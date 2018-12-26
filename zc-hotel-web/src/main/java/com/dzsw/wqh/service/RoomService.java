package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.RoomEntityMapper;
import com.dzsw.wqh.plugins.PageHelper;
import com.dzsw.wqh.plugins.PageHelper.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class RoomService {

    @Resource
    private RoomEntityMapper roomEntityMapper;

    public Page queryRoomByPage(Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);
        roomEntityMapper.selectAll();
        return  PageHelper.endPage();
    }
}
