package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.dao.*;
import com.example.meetingspringboot.po.*;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.OrderVo;
import com.example.meetingspringboot.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;
import java.util.List;
import java.util.Stack;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Resource
    private AppointmentDetailTimeMapper appointmentDetailTimeMapper;
    @Resource
    private UserMapper userMapper;
    @Resource
    private AppointmentMapper appointmentMapper;
    @Resource
    private RoomMapper roomMapper;
    @Override
    public OrderEntity addOrder(OrderEntity orderEntity) {
        ZoneId zoneId = ZoneId.systemDefault();
        LocalDateTime localDateTime = LocalDateTime.now();
        ZonedDateTime zdt = localDateTime.atZone(zoneId);
        Date date = Date.from(zdt.toInstant());
        orderEntity.setCreateTime(date);
        UserEntity userEntity=userMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_id",orderEntity.getOrderUserId()));
        AppointmentEntity appointmentEntity=appointmentMapper.selectOne(new QueryWrapper<AppointmentEntity>().eq("appointment_id",orderEntity.getOrderAppointmentId()));
        RoomEntity roomEntity=roomMapper.selectById(appointmentEntity.getAppointmentRoomId());
        System.out.println(roomEntity);
        System.out.println(appointmentEntity);
        if(userEntity.getCollegeId()==roomEntity.getRoomCollegeId()){
            orderEntity.setApproval(0);
        }else if(roomEntity.getRoomCollegeId()==1||userEntity.getCollegeId()==1){
            orderEntity.setApproval(0);
        }else {
            orderEntity.setApproval(1);
        }
        orderMapper.insert(orderEntity);
        orderEntity.setBz("http://localhost:8090/qrcode/getQRCode?content="+orderEntity.getOrderId()+"&logoUrl=https://img02.viwik.com/20181017/viwik_sy_11470747729356.jpg");
        orderMapper.updateById(orderEntity);
        System.out.println(orderEntity);
        String ids=orderEntity.getOrderPeriodIds();
        System.out.println(ids);
        String[] collection = ids.split(",");
        System.out.println(collection[0]);
        for(int i=0;i<collection.length;i++) {
            System.out.println(collection[i]);
        AppointmentDetailTimeEntity appointmentDetailTimeEntity=appointmentDetailTimeMapper.selectOne(new QueryWrapper<AppointmentDetailTimeEntity>().eq("appointment_time_period_id",Integer.parseInt(collection[i])).eq("datail_appointment_id",orderEntity.getOrderAppointmentId()));
            appointmentDetailTimeEntity.setAppointmentState(1);
            appointmentDetailTimeMapper.updateById(appointmentDetailTimeEntity);
        }
        return orderEntity;
    }

    @Override
    public OrderEntity deleteOrder(OrderEntity orderEntity) {
        int orderId=orderEntity.getOrderId();
        OrderEntity orderEntity1=orderMapper.selectById(orderId);
        orderEntity1.setOrderState(1);
        orderMapper.updateById(orderEntity1);
        String ids=orderEntity1.getOrderPeriodIds();
        System.out.println(ids);
        String[] collection = ids.split(",");
        System.out.println(collection[0]);
        for(int i=0;i<collection.length;i++) {
            System.out.println(collection[i]);
            AppointmentDetailTimeEntity appointmentDetailTimeEntity=appointmentDetailTimeMapper.selectOne(new QueryWrapper<AppointmentDetailTimeEntity>().eq("appointment_time_period_id",Integer.parseInt(collection[i])).eq("datail_appointment_id",orderEntity1.getOrderAppointmentId()));
            appointmentDetailTimeEntity.setAppointmentState(0);
            appointmentDetailTimeMapper.updateById(appointmentDetailTimeEntity);
            System.out.println(appointmentDetailTimeEntity);
        }
        return orderEntity1;
    }

    @Override
    public IPage<OrderVo> selectUserOrder(Integer currentPage, Integer pageSize, OrderVo orderVo) {
        IPage<OrderVo>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<OrderVo> queryWrapper=new QueryWrapper<>();
        if (orderVo.getOrderUserId()!=null) {
            queryWrapper.eq("user_order.order_user_id", orderVo.getOrderUserId());
        }
        if (orderVo.getOrderId()!=null) {
            queryWrapper.eq("user_order.order_id", orderVo.getOrderId());
        }
        if (orderVo.getApproval()!=null){
            queryWrapper.eq("user_order.approval",orderVo.getApproval());
        }
        if (orderVo.getNumber()!=null){
            queryWrapper.eq("user.number",orderVo.getNumber());
        }
        queryWrapper.orderByDesc("user_order.order_id");
        IPage<OrderVo> orderVoIPage = orderMapper.selectUserOrder(iPage, queryWrapper);
        List<OrderVo> records = orderVoIPage.getRecords();
        orderVoIPage.setRecords(records);
        return orderVoIPage;
    }

    @Override
    public OrderEntity buhuiOrder(OrderEntity orderEntity) {
        OrderEntity orderEntity1=orderMapper.selectById(orderEntity.getOrderId());
        orderEntity1.setApproval(2);
        orderMapper.updateById(orderEntity1);
        return orderEntity1;
    }
    @Override
    public OrderEntity succussOrder(OrderEntity orderEntity) {
        OrderEntity orderEntity1=orderMapper.selectById(orderEntity.getOrderId());
        orderEntity1.setApproval(0);
        orderMapper.updateById(orderEntity1);
        return orderEntity1;
    }

    @Override
    public String idsToTime(String ids) {
        System.out.println(ids);
        String time="";
        String[] collection = ids.split(",");
        System.out.println(collection[1]);
        Stack<Integer> start = new Stack<>();
        Stack<Integer> end = new Stack<>();
        start.push(Integer.parseInt(collection[0]));
        for(int i=1;i<collection.length;i++) {
            if (Integer.parseInt(collection[i])!=Integer.parseInt(collection[i-1])+1){
                start.push(Integer.parseInt(collection[i]));
                end.push(Integer.parseInt(collection[i-1]));
            }else {
            }
        }
        end.push(Integer.parseInt(collection[collection.length-1]));
        System.out.println("start"+start);
        System.out.println("end"+end);
        while (!start.isEmpty()){
            if (start.peek()==end.peek()){
                time=(start.pop()+7)+":00~"+(end.pop()+8)+":00"+" "+time;
            }else {
                time=(start.pop()+7)+":00~"+(end.pop()+8)+":00"+" "+time;

            }
        }
        System.out.println(time);
        return time;
    }

}
