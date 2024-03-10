package com.example.meetingspringboot.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.example.meetingspringboot.po.AppointmentEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.meetingspringboot.po.vo.AppointmentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wbb
 * @since 2023-11-10
 */
@Mapper
public interface AppointmentMapper extends BaseMapper<AppointmentEntity> {
    IPage<AppointmentVo> selectAppointment(IPage<AppointmentVo> iPage, @Param(Constants.WRAPPER) QueryWrapper<AppointmentVo> queryWrapper);

    IPage<AppointmentEntity> selectRoomkong(IPage<AppointmentEntity> iPage, @Param(Constants.WRAPPER) QueryWrapper<AppointmentEntity> queryWrapper);

}
