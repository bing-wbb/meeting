package com.example.meetingspringboot.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.vo.AppointmentDetailVo;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.service.AppointmentDetailTimeService;
import com.example.meetingspringboot.util.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
@RequestMapping("/appointmentDetailTimeEntity")
public class AppointmentDetailTimeController {
    @Autowired
    private AppointmentDetailTimeService appointmentDetailTimeService;
    @PostMapping("selectAppointmentDetail")
    public JsonData selectAppointmentDetail(Integer page, Integer limit, AppointmentDetailVo appointmentDetailVo){
        IPage<AppointmentDetailVo> appointmentDetailVoIPage = appointmentDetailTimeService.appointmentDetailVoIPage(page, limit, appointmentDetailVo);
        if(appointmentDetailVoIPage!=null){
            return JsonData.buildSuccess(appointmentDetailVoIPage);
        }else {
            return JsonData.buildError("error");
        }
    }


}

