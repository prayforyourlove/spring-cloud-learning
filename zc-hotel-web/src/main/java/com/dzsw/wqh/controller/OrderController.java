package com.dzsw.wqh.controller;

import com.dzsw.wqh.enumeration.ResultEnum;
import com.dzsw.wqh.plugins.PageHelper.Page;
import com.dzsw.wqh.model.OrderEntity;
import com.dzsw.wqh.protocol.ReserveRoomRequest;
import com.dzsw.wqh.protocol.ResultResponse;
import com.dzsw.wqh.service.OrderService;
import com.dzsw.wqh.util.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value ="/reserve")
    public ResultResponse reserveRoom(@Validated @RequestBody ReserveRoomRequest reserveRequest) {

        log.info("预定房间请求参数:{}", JsonUtils.objectToJson(reserveRequest));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(reserveRequest.getUserId());
        orderEntity.setRoomNo(reserveRequest.getRoomNo());
        boolean result = orderService.saveOrder(orderEntity);
        ResultResponse resultResponse;
        if(result){
            resultResponse=ResultResponse.buildResponse(ResultEnum.SUCCESS);
        }else {
            resultResponse=ResultResponse.buildResponse(ResultEnum.FAIL);
        }
        return resultResponse;
    }

    @GetMapping()
    public ResultResponse queryOrder(@RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageSize")Integer pageSize) {
        Page page = orderService.queryRoomByPage(pageNum, pageSize);
        ResultResponse resultResponse;
        if (page.getTotal()!=0){
            resultResponse = ResultResponse.buildResponseData(ResultEnum.SUCCESS, page.getResult());
        }else {
            resultResponse = ResultResponse.buildResponse(ResultEnum.FAIL);
        }
        return resultResponse;
    }

    @DeleteMapping()
    public ResultResponse delete(@RequestParam(value = "orderNo") Integer orderNo ){
        boolean result=orderService.deleteOrderByOrderNo(orderNo);
        ResultResponse resultResponse;
        if(result){
            resultResponse=ResultResponse.buildResponse(ResultEnum.SUCCESS);
        }else {
            resultResponse=ResultResponse.buildResponse(ResultEnum.FAIL);
        }
        return resultResponse;
    }
}
