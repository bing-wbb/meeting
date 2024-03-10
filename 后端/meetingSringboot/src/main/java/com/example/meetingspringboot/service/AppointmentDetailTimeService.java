package com.example.meetingspringboot.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.meetingspringboot.po.AppointmentDetailTimeEntity;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.meetingspringboot.po.vo.AppointmentDetailVo;
import com.example.meetingspringboot.po.vo.AppointmentVo;
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
public interface AppointmentDetailTimeService {
    IPage<AppointmentDetailVo> appointmentDetailVoIPage(Integer currentPage, Integer pageSize, AppointmentDetailVo AppointmentDetailVo);

}
