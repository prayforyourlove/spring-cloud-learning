package com.dzsw.wqh.mapper;

import com.dzsw.wqh.model.RoomEntity;
import com.dzsw.wqh.util.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface RoomEntityMapper extends MyMapper<RoomEntity> {

    int reduceRoomCount(@Param("roomNo") int roomNo);
}