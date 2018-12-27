package com.dzsw.wqh.controller;

import com.dzsw.wqh.model.OrderEntity;
import com.dzsw.wqh.protocol.ReserveRoomRequest;
import com.dzsw.wqh.service.OrderService;
import com.dzsw.wqh.util.JsonUtils;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(value ="/reserve")
    public String reserveRoom(Model model, @Validated @RequestBody ReserveRoomRequest reserveRequest) {

        log.info("预定房间请求参数:{}", JsonUtils.objectToJson(reserveRequest));
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setUserId(reserveRequest.getUserId());
        orderEntity.setRoomNo(reserveRequest.getRoomNo());
        boolean result = orderService.saveOrder(orderEntity);
        if (result){
            model.addAttribute("result","预定房间成功");
            //跳转到查询订单列表
            return "redirect:/list";
        }
        model.addAttribute("result","预定房间失败");
        //跳转到房间列表
        return "search";
    }

    @GetMapping()
    public String queryOrder(Model model,@RequestParam(value = "pageNum") Integer pageNum,
                                    @RequestParam(value = "pageSize")Integer pageSize) {
        PageInfo<OrderEntity> pageInfo = orderService.queryRoomByPage(pageNum, pageSize);
        List<OrderEntity> orderEntities = pageInfo.getList();
        long total = pageInfo.getTotal();
        model.addAttribute("order",orderEntities);
        model.addAttribute("total",total);
        //跳转到查询订单列表
        return "list";
    }

    @DeleteMapping()
    public String delete(Model model,@RequestParam(value = "orderNo") Integer orderNo ){
        boolean result = orderService.deleteOrderByOrderNo(orderNo);
        if (result) {
            model.addAttribute("result", "删除订单成功");
        } else {
            model.addAttribute("result", "删除订单失败");
        }
        //跳转到查询订单列表
        return "list";

    }
}
