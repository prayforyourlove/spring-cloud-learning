package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.RoomEntityMapper;
import com.dzsw.wqh.model.RoomEntity;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RoomService {

    @Resource
    private RoomEntityMapper roomEntityMapper;

    public List<RoomEntity> queryRoomByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<RoomEntity> roomEntities = roomEntityMapper.selectAll();
        return  roomEntities;
    }
}
