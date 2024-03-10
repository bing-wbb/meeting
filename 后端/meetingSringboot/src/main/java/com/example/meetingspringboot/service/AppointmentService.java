package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.po.vo.RoomVo;
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
public interface AppointmentService {
    AppointmentEntity addAppointment(AppointmentEntity appointmentEntity);
    int deleteAppointment(AppointmentEntity appointmentEntity);
    IPage<AppointmentVo> appointmentSelect(Integer currentPage, Integer pageSize, AppointmentVo AppointmentVo);

}
