package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.RoomEntityMapper;
import com.dzsw.wqh.model.RoomEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service
public class RoomService {

    @Resource
    private RoomEntityMapper roomEntityMapper;

    public PageInfo<RoomEntity> queryRoomByPage(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<RoomEntity> roomEntities = roomEntityMapper.selectAll();
        return new PageInfo<>(roomEntities);
    }
}
