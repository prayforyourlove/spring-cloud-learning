package com.dzsw.wqh.service;

import com.dzsw.wqh.mapper.OrderEntityMapper;
import com.dzsw.wqh.mapper.RoomEntityMapper;
import com.dzsw.wqh.model.OrderEntity;
import com.dzsw.wqh.model.RoomEntity;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

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

    public PageInfo<OrderEntity> queryRoomByPage(Integer pageNum, Integer pageSize) {
        if (pageNum != null && pageSize != null) {
            PageHelper.startPage(pageNum, pageSize);
        }
        List<OrderEntity> orderEntities = orderEntityMapper.selectAll();
        return new PageInfo<>(orderEntities);
    }

    public boolean deleteOrderByOrderNo(Integer orderNo) {
        int i = orderEntityMapper.deleteByPrimaryKey(orderNo);
        return i>0;
    }
}
