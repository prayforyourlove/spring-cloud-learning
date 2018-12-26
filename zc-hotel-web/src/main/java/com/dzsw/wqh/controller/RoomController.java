package com.dzsw.wqh.controller;


import com.dzsw.wqh.enumeration.ResultEnum;
import com.dzsw.wqh.plugins.PageHelper.Page;
import com.dzsw.wqh.protocol.ResultResponse;
import com.dzsw.wqh.service.RoomService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping(value = "/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping()
    public ResultResponse queryRoom(@RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageSize")Integer pageSize) {
        Page page = roomService.queryRoomByPage(pageNum, pageSize);
        ResultResponse resultResponse;
        if (page.getTotal()!=0){
            resultResponse = ResultResponse.buildResponseData(ResultEnum.SUCCESS, page.getResult());
        }else {
            resultResponse = ResultResponse.buildResponse(ResultEnum.FAIL);
        }
        return resultResponse;
    }



}
