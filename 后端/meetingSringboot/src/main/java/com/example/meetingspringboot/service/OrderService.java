package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.OrderEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.OrderVo;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public interface OrderService {
    OrderEntity addOrder(OrderEntity orderEntity);
    OrderEntity deleteOrder(OrderEntity orderEntity);
    IPage<OrderVo> selectUserOrder(Integer currentPage, Integer pageSize, OrderVo orderVo);

    OrderEntity buhuiOrder(OrderEntity orderEntity);

    OrderEntity succussOrder(OrderEntity orderEntity);

    String idsToTime(String ids);

}
