package com.example.meetingspringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.meetingspringboot.po.AppointmentDetailTimeEntity;
import com.example.meetingspringboot.dao.AppointmentDetailTimeMapper;
import com.example.meetingspringboot.po.vo.AppointmentDetailVo;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import com.example.meetingspringboot.service.AppointmentDetailTimeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Service
public class AppointmentDetailTimeServiceImpl implements AppointmentDetailTimeService {
    @Resource
    private AppointmentDetailTimeMapper appointmentDetailTimeMapper;
    @Override
    public IPage<AppointmentDetailVo> appointmentDetailVoIPage(Integer currentPage, Integer pageSize, AppointmentDetailVo appointmentDetailVo) {
        IPage<AppointmentDetailVo>iPage=new Page<>(currentPage,pageSize);
        QueryWrapper<AppointmentDetailVo> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("appointment_room_id",appointmentDetailVo.getAppointmentRoomId());
        queryWrapper.eq("appointment_date",appointmentDetailVo.getAppointmentDate());
//        if (appointmentDetailVo.getAppointmentState()!=null){
//            queryWrapper.eq("appointment_state",appointmentDetailVo.getAppointmentState());
//        }
//        if (appointmentDetailVo.getDetailAppointmentId()!=null){
//            queryWrapper.eq("detail_appointment_id",appointmentDetailVo.getDetailAppointmentId());
//        }
//        if (appointmentDetailVo.getDetailAppointmentDate()!=null){
//            queryWrapper.eq("detail_appointment_date",appointmentDetailVo.getDetailAppointmentDate());
//        }
//        queryWrapper.like(StringUtils.isNoneBlank(roomVo.getTitle()),"title",roomVo.getTitle());
//        queryWrapper.like(StringUtils.isNoneBlank(roomVo.getType()),"type",roomVo.getType());

//        queryWrapper.eq("appointment_id",appointmentDetailVo.getAppointmentId());
//        queryWrapper.eq("appointment_date",appointmentDetailVo.getAppointmentDate());
        IPage<AppointmentDetailVo> appointmentDetailVoIPage = appointmentDetailTimeMapper.selectAppointmentDetail(iPage, queryWrapper);
        List<AppointmentDetailVo> records = appointmentDetailVoIPage.getRecords();
        appointmentDetailVoIPage.setRecords(records);
        return appointmentDetailVoIPage;
    }
}
