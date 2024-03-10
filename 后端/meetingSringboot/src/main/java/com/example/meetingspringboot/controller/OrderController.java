package com.example.meetingspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.OrderEntity;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.OrderVo;
import com.example.meetingspringboot.service.OrderService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@RestController
@RequestMapping("/orderEntity")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @PostMapping("orderAdd")
    public JsonData addOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity orderEntity1 = orderService.addOrder(orderEntity);
        if(orderEntity1==null){
            return JsonData.buildError("预约失败");
        }
        return JsonData.buildSuccess(orderEntity1);
    }

    @PostMapping("selectUserOrder")
    public JsonData selectUserOrder(Integer page, Integer limit, OrderVo orderVo){
        IPage<OrderVo> orderVoIPage = orderService.selectUserOrder(page, limit, orderVo);
        if(orderVoIPage!=null){
            return JsonData.buildSuccess(orderVoIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
    @PostMapping("backOrder")
    public JsonData backOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity orderEntity1 = orderService.buhuiOrder(orderEntity);
        if(orderEntity1!=null){
            return JsonData.buildSuccess(orderEntity1);
        }else {
            return JsonData.buildError("error");
        }
    }
    @PostMapping("successOrder")
    public JsonData successOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity orderEntity1 = orderService.succussOrder(orderEntity);
        if(orderEntity1!=null){
            return JsonData.buildSuccess(orderEntity1);
        }else {
            return JsonData.buildError("error");
        }
    }
    //    将时间的id值转化为时间段
    @PostMapping("idToTIme")
    public JsonData idToTIme( String ids){
        String time = orderService.idsToTime(ids);
        if(time!=null){
            return JsonData.buildSuccess(time);
        }else {
            return JsonData.buildError("error");
        }
    }
//    取消订单
    @PostMapping("cancelOrder")
    public JsonData cancelOrder(@RequestBody OrderEntity orderEntity){
        OrderEntity orderEntity1 = orderService.deleteOrder(orderEntity);
        if(orderEntity1!=null){
            return JsonData.buildSuccess(orderEntity1);
        }else {
            return JsonData.buildError("error");
        }
    }
}

