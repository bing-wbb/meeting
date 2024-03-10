package com.example.meetingspringboot.controller;


import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.example.meetingspringboot.po.RoomEntity;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.RoomVo;
import com.example.meetingspringboot.service.AppointmentService;
import com.example.meetingspringboot.service.OrderService;
import com.example.meetingspringboot.service.RoomService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@RestController
@RequestMapping("/appointmentEntity")
public class AppointmentController {
    @Autowired
    private AppointmentService appointmentService;
    @Autowired
    private OrderService orderService;
    @PostMapping("appointmentAdd")
    public JsonData addAppointment(@RequestBody AppointmentEntity appointmentEntity){
        AppointmentEntity appointmentEntity1 = appointmentService.addAppointment(appointmentEntity);
        if(appointmentEntity1==null){
            return JsonData.buildError("用户已存在");
        }
        return JsonData.buildSuccess(appointmentEntity1);
    }
    @PostMapping("selectAppointment")
    public JsonData selectAppointment(Integer page, Integer limit, AppointmentVo appointmentVo){
        IPage<AppointmentVo> appointmentVoIPage = appointmentService.appointmentSelect(page, limit, appointmentVo);
        if(appointmentVoIPage!=null){
            return JsonData.buildSuccess(appointmentVoIPage);
        }else {
            return JsonData.buildError("error");
        }
    }
    @DeleteMapping("deleteAppointment")
    public JsonData deleteAppointment(@RequestBody AppointmentEntity appointmentEntity){
        int i = appointmentService.deleteAppointment(appointmentEntity);
        if(i!=0){
            return JsonData.buildSuccess(i);
        }else {
            return JsonData.buildError("error");
        }
    }
    @PostMapping("/upload")
    public JsonData upload(@RequestBody List<Map<String, Object>> data) {
        // 处理上传的数据
        for (int j=1;j<=7;j++) {
            for (int i = 0; i < data.size(); i++) {
                Map<String, Object> data1 = data.get(i); // 获取第一个人的信息
                System.out.println(data1);
                AppointmentEntity appointmentEntity = new AppointmentEntity();
                String dd = "";
                for (Map.Entry<String, Object> entry : data1.entrySet()) {
                    if (entry.getKey().equals("appointmentRoomId")) {
                        appointmentEntity.setAppointmentRoomId((Integer) entry.getValue());
                    } else if (entry.getKey().equals("appointmentDate")) {
                        dd = (String) entry.getValue();
                        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            Date time = df.parse(dd);
                            Calendar calendar = new GregorianCalendar();
                            calendar.setTime(time);
                            // 把日期往后增加一天,整数  往后推,负数往前移动
                            calendar.add(Calendar.DATE, j);
                            // 这个时间就是日期往后推一天的结果
                            time = calendar.getTime();
                            appointmentEntity.setAppointmentDate(time);
                        } catch (ParseException e) {
                            e.printStackTrace();
                        }
                    } else if (entry.getKey().equals("appointmentPeriodIds")) {
                        String time = orderService.idsToTime((String) entry.getValue());
                        appointmentEntity.setAppointmentPeriodIds((String) entry.getValue());
                        appointmentEntity.setAppointmentPeriodTimeProid(time);
                    }
                }
                System.out.println(appointmentEntity);
                appointmentService.addAppointment(appointmentEntity);
            }
        }
        return JsonData.buildSuccess("上传成功");
    }
//    public JsonData upload(@RequestBody List<Map<String, Object>> data) {
//        // 处理上传的数据
//        for (int i=0;i<data.size();i++){
//            Map<String, Object> data1 = data.get(i); // 获取第一个人的信息
//            System.out.println(data1);
//            AppointmentEntity appointmentEntity=new AppointmentEntity();
//            String dd="";
//            for (Map.Entry<String, Object> entry : data1.entrySet()) {
//                if (entry.getKey().equals("appointmentRoomId")){
//                    appointmentEntity.setAppointmentRoomId((Integer) entry.getValue());
//                }else if (entry.getKey().equals("appointmentDate")){
//                    dd=(String) entry.getValue();
//                    SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
//                    try {
//                        Date time =df.parse(dd);
//                        Calendar calendar = new GregorianCalendar();
//                        calendar.setTime(time);
//                        // 把日期往后增加一天,整数  往后推,负数往前移动
//                        calendar.add(Calendar.DATE, 1);
//                        // 这个时间就是日期往后推一天的结果
//                        time = calendar.getTime();
//                        appointmentEntity.setAppointmentDate(time);
//                    } catch (ParseException e) {
//                        e.printStackTrace();
//                    }
//                }else if (entry.getKey().equals("appointmentPeriodIds")){
//                    appointmentEntity.setAppointmentPeriodIds((String) entry.getValue());
//                }
//            }
//            System.out.println(appointmentEntity);
//           appointmentService.addAppointment(appointmentEntity);
//        }
//        return JsonData.buildSuccess("上传成功");
//    }


}

