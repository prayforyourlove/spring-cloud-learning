package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.OrderEntityMapper;
import com.dzsw.wqh.mapper.RoomEntityMapper;
import com.dzsw.wqh.model.OrderEntity;
import com.dzsw.wqh.model.RoomEntity;
import com.dzsw.wqh.plugins.PageHelper;
import com.dzsw.wqh.plugins.PageHelper.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;

@Service
@Transactional(rollbackFor = Exception.class)
public class OrderService {


    @Resource
    private OrderEntityMapper orderEntityMapper;

    @Resource
    private RoomEntityMapper roomEntityMapper;

    public boolean saveOrder(OrderEntity orderEntity) {

        Integer roomNo = orderEntity.getRoomNo();
        RoomEntity roomEntity = roomEntityMapper.selectByPrimaryKey(roomNo);
        orderEntity.setInsertTime(new Date());
        if (roomEntity==null){
            return false;
        }
        orderEntity.setOrderAmount(roomEntity.getPrice());
        int i = orderEntityMapper.insertSelective(orderEntity);
        int y=0;
        if (i>0){
            y= roomEntityMapper.reduceRoomCount(roomNo);
        }
        return y>0 ;
    }

    public Page queryRoomByPage(Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        orderEntityMapper.selectAll();
        return  PageHelper.endPage();
    }

    public boolean deleteOrderByOrderNo(Integer orderNo) {
        int i = orderEntityMapper.deleteByPrimaryKey(orderNo);
        return i>0;
    }
}
