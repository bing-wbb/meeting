package com.example.meetingspringboot.timer;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.meetingspringboot.dao.AppointmentDetailTimeMapper;
import com.example.meetingspringboot.dao.AppointmentMapper;
import com.example.meetingspringboot.dao.OrderMapper;
import com.example.meetingspringboot.po.AppointmentDetailTimeEntity;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.OrderEntity;
import com.example.meetingspringboot.service.AppointmentDetailTimeService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
@EnableScheduling   // 1.开启定时任务
@EnableAsync        // 2.开启多线程
public class InformationTimer {
    @Autowired
    private AppointmentDetailTimeService appointmentDetailTimeService;
    @Autowired
    private AppointmentMapper appointmentMapper;
    @Autowired
    private AppointmentDetailTimeMapper appointmentDetailTimeMapper;
    @Autowired
    private OrderMapper orderMapper;
    @Async  //将一个同步方法转换为异步方法(多线程)
//    @Scheduled(cron= "0/5 * *  * * ? ") //每5秒执行一次
    @Scheduled(cron= "0 0 8-22  * * ? ") //每天8-22点整点更新
    public void testTimer1(){
        Logger logger = LoggerFactory.getLogger(getClass());
        System.out.println("定时器被触发" + new Date());
        QueryWrapper<AppointmentDetailTimeEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("appointment_state", 0);
        List<Map<String, Object>> maps = appointmentDetailTimeMapper.selectMaps(queryWrapper);
        System.out.println(maps);
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("expiration_time"));
            Object date1= map.get("expiration_time");
            String date2= date1.toString();
            System.out.println("date2=="+date2);
            String[]  dd=date2.split("-|:|\\.| ");
            String date3=dd[0]+"-"+dd[1]+"-"+dd[2]+"T"+dd[3]+":"+dd[4]+":"+dd[5]+"."+dd[6];
            System.out.println("date3="+date3);
            LocalDateTime date4= LocalDateTime.parse(date3);
            System.out.println("date4=="+date4);
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime);
            if (date4.isBefore(localDateTime)) {
                AppointmentDetailTimeEntity appointmentDetailTimeEntity = appointmentDetailTimeMapper.selectById((Integer) map.get("appoinment_datail_time_id"));
                appointmentDetailTimeEntity.setAppointmentState(1);
                appointmentDetailTimeMapper.updateById(appointmentDetailTimeEntity);
            }
        }
    }

    @Async  //将一个同步方法转换为异步方法(多线程)
//    @Scheduled(cron= "0/5 * *  * * ? ") //每5秒执行一次
    @Scheduled(cron= "0 0 8-22  * * ? ") //每天8-22点整点更新
    public void orderChaoshi(){
        Logger logger = LoggerFactory.getLogger(getClass());
        System.out.println("定时器被触发" + new Date());
        QueryWrapper<OrderEntity> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("order_state", 0);
        List<Map<String, Object>> maps = orderMapper.selectMaps(queryWrapper);
        System.out.println(maps);
        for (Map<String, Object> map : maps) {
            System.out.println(map.get("order_appointment_id"));
            int appointmentId= (int) map.get("order_appointment_id");
            System.out.println("appointmentId="+appointmentId);
            AppointmentEntity appointmentEntity=appointmentMapper.selectById(appointmentId);
            Date date=appointmentEntity.getAppointmentDate();
            Instant instant = date.toInstant();
            ZoneId zoneId = ZoneId.systemDefault();
            // atZone()方法返回在指定时区从此Instant生成的ZonedDateTime。
            LocalDate localDate = instant.atZone(zoneId).toLocalDate();
            System.out.println("Date = " + date);
            System.out.println("LocalDate = " + localDate);
            String orderDate= String.valueOf(localDate);
            System.out.println("orderDate="+orderDate);
            String ids= (String) map.get("order_period_ids");

            String idss[]=ids.split(",");
            int start=Integer.parseInt(idss[0]);
            int end= Integer.parseInt(idss[0]);
            for (int i=1;i<idss.length;i++){
                if (Integer.parseInt(idss[i])>end){
                    end=Integer.parseInt(idss[i]);
                }
                if (Integer.parseInt(idss[i])<start){
                    start=Integer.parseInt(idss[i]);
                }
            }
            if (start==end){
                start=start+8;
                if (start<10){
                    orderDate=orderDate+"T"+"0"+start+":00:00.000";
                }else {
                    orderDate=orderDate+"T"+start+":00:00.000";
                }
            }else {
                start=start+8;
                end=end+8;
                if (end<10){
                    orderDate=orderDate+"T"+"0"+end+":00:00.000";
                }else {
                    orderDate=orderDate+"T"+end+":00:00.000";
                }
            }
            System.out.println("gwyfgwif="+orderDate);
//            Object date1= map.get("expiration_time");
//            String date2= date1.toString();
//            System.out.println("date2=="+date2);
//            String[]  dd=date2.split("-|:|\\.| ");
//            String date3=dd[0]+"-"+dd[1]+"-"+dd[2]+"T"+dd[3]+":"+dd[4]+":"+dd[5]+"."+dd[6];
//            System.out.println("date3="+date3);
            LocalDateTime date4= LocalDateTime.parse(orderDate);
            System.out.println("date4=="+date4);
            LocalDateTime localDateTime = LocalDateTime.now();
            System.out.println(localDateTime);
            if (date4.isBefore(localDateTime)) {
                OrderEntity orderEntity = orderMapper.selectById((Integer) map.get("order_id"));
                orderEntity.setOrderState(2);
                orderMapper.updateById(orderEntity);
            }
        }
    }


}

