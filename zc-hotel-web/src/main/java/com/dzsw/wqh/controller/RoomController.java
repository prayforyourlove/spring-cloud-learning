package com.dzsw.wqh.controller;


import com.dzsw.wqh.model.RoomEntity;
import com.dzsw.wqh.service.RoomService;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping()
    public String queryRoom(Model model, @RequestParam(value = "pageNum") Integer pageNum,
                            @RequestParam(value = "pageSize")Integer pageSize) {
        PageInfo<RoomEntity> pageInfo = roomService.queryRoomByPage(pageNum, pageSize);
        List<RoomEntity> roomEntitys = pageInfo.getList();
        long total = pageInfo.getTotal();
        model.addAttribute("room",roomEntitys);
        model.addAttribute("total",total);
        //跳转到查询房间列表
        return "search";
    }



}
